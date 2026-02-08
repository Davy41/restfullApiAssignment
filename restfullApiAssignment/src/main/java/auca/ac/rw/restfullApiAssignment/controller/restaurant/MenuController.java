package auca.ac.rw.restfullApiAssignment.controller.restaurant;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class MenuController {
    
    public static class Menu {
        public Long id;
        public String name;
        public Double price;
        public String category;
        public boolean available;

        public Menu() {
        }

        public Menu(Long id, String name, Double price, String category, boolean available) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.category = category;
            this.available = available;
        }
    }

    // In-memory menu store
    public List<Menu> menus = new ArrayList<>(Arrays.asList(
        new Menu(1L, "Fillet Mignon", 10.99, "Main Course", true),
        new Menu(2L, "Chicken Burger", 8.99, "Entree", true),
        new Menu(3L, "crepe", 12.99, "dessert", false)
    ));

    @GetMapping(value="/menu")
    public List<Menu> getMenu(){
        return menus;
    }

    @GetMapping(value="/menu/{i}")
    public ResponseEntity<Menu> getMenuById(@PathVariable Long i){
        Optional<Menu> found = menus.stream().filter(m -> m.id.equals(i)).findFirst();
        return found.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping(value="/menu/category/{category}")
    public List<Menu> getMenuByCategory(@PathVariable String category){
        return menus.stream()
            .filter(m -> m.category != null && m.category.equalsIgnoreCase(category))
            .collect(Collectors.toList());
    }

    @GetMapping(value="/menu/available")
    public List<Menu> getMenuByAvailability(@RequestParam(required = false) Boolean available){
        if (available == null) return menus;
        return menus.stream()
            .filter(m -> m.available == available)
            .collect(Collectors.toList());
    }

    @GetMapping(value="/menu/search")
    public List<Menu> searchMenuByName(@RequestParam String name){
        String q = name == null ? "" : name.toLowerCase();
        return menus.stream()
            .filter(m -> m.name != null && m.name.toLowerCase().contains(q))
            .collect(Collectors.toList());
    }

    @PostMapping(value="/menu")
    public ResponseEntity<Menu> addMenu(@RequestBody Menu newMenu){
        long maxId = menus.stream().mapToLong(m -> m.id).max().orElse(0L);
        newMenu.id = maxId + 1;
        // default availability true if not provided
        menus.add(newMenu);
        return ResponseEntity.status(HttpStatus.CREATED).body(newMenu);
    }

    @PutMapping(value="/menu/{id}/availability")
    public ResponseEntity<Menu> toggleAvailability(@PathVariable Long id){
        Optional<Menu> found = menus.stream().filter(m -> m.id.equals(id)).findFirst();
        if (!found.isPresent()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        Menu m = found.get();
        m.available = !m.available;
        return ResponseEntity.ok(m);
    }

    @DeleteMapping(value="/menu/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long id){
        boolean removed = menus.removeIf(m -> m.id.equals(id));
        if (!removed) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.noContent().build();
    }
}    


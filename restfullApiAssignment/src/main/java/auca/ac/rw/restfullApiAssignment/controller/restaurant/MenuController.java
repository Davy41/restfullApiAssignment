package auca.ac.rw.restfullApiAssignment.controller.restaurant;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

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

@RestController
@RequestMapping("/api")
public class MenuController {
    
    public static class Menu {
        public Long id;
        public String name;
        public Double price;
        public String category;
        
        public Menu() {
        }
        
        public Menu(Long id, String name, Double price, String category) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.category = category;
        }
    }

    public List<Long> id = new ArrayList<>(Arrays.asList(1L, 2L, 3L));
    public List<String> name = new ArrayList<>(Arrays.asList("Fillet Mignon","Chicken Burger","crepe"));
    public List<Double> price = new ArrayList<>(Arrays.asList(10.99, 8.99, 12.99));
    public List<String> category = new ArrayList<>(Arrays.asList("Main Course", "Entree", "dessert"));

    @GetMapping(value="/menu")
    public ResponseEntity<List<Menu>> getMenu(){
        List<Menu> menuList = new ArrayList<>();
        for(int i=0; i<id.size(); i++){
            menuList.add(new Menu(
                id.get(i),
                name.get(i),
                price.get(i), 
                category.get(i)
            ));
        }
        return ResponseEntity.ok(menuList);
    }
}    


package auca.ac.rw.restfullApiAssignment.controller.library;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api")

public class BookController {
    

    public List<String> title = new ArrayList<>(Arrays.asList("Chernobyl","The Alchemist","Brunhilde"));
    public List<Integer> id = new ArrayList<>(Arrays.asList(1,2,3));
    public List<String> Author = new ArrayList<>(Arrays.asList("Svetlana Alexievich","Paulo Coelho","Klaus Mann"));
    public List<String> ISBN = new ArrayList<>(Arrays.asList("978-0312424980","978-0061122415","978-0143034952"));
    public List<Integer> publicationYear = new ArrayList<>(Arrays.asList(2013,1988,1937));

    @GetMapping(value="/books")
    public List<String> getBooks() {
        return title ;
    }

    @GetMapping(value="/books/{id}")
    public String getBookById(@PathVariable Integer id) {
        for(int i=0; i<title.size(); i++){
            if(this.id.get(i).equals(id)){
                return title.get(i);
            }
        }
        return "Book not found";
    }

    @GetMapping(value="/books/search")
    public String searchBook(@RequestParam("title") String name){
        for(int i=0; i<title.size();i++){
            if(title.get(i).equals(name)){
                return title.get(i);
            }
        }
        return "Book not found";
    }

    @PostMapping(value="/books")
    public String addBook(@RequestParam("title") String titleValue, @RequestParam("id")Integer idValue){
        title.add(titleValue);
        id.add(idValue);
        return "Book added successfully";
    }

    @DeleteMapping(value="/books/{id}")
    public String deleteBook(@PathVariable Integer id){
        for(int i=0; i<title.size();i++){
            if(this.id.get(i).equals(id)){
                title.remove(i);
                this.id.remove(i);
                Author.remove(i);
                ISBN.remove(i);
                publicationYear.remove(i);
                return "Deleted Successfully";
            }
        } 
        return "Item Not found";
    }



    }


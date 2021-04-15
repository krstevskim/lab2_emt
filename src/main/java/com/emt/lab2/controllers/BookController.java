package com.emt.lab2.controllers;


import com.emt.lab2.model.domain.Book;
import com.emt.lab2.model.dto.BookDTO;
import com.emt.lab2.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public List<Book> findAll() {
        return this.service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return this.service.findById(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Book> create(@RequestBody BookDTO bookDto) {
        return this.service.create(bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<Book> edit(@PathVariable Long id,@RequestBody BookDTO bookDto) {
        return this.service.edit(id,bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        this.service.deleteById(id);
        if(this.service.findById(id).isEmpty()) return ResponseEntity.ok().body("Item Deleted");
        return ResponseEntity.badRequest().body("Something went wrong");
    }

    @PostMapping("/{id}/decrease")
    public ResponseEntity<String> decreaseAvailableBooks(@PathVariable Long id) {
        if(this.service.decreaseAvailableCopies(id)) {
            return ResponseEntity.ok().body("Quantity of available copies decreased!!!");
        }
       return ResponseEntity.ok().body("There are not available copies of this books");
    }

}

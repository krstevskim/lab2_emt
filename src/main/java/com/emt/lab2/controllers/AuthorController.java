package com.emt.lab2.controllers;

import com.emt.lab2.model.domain.Author;
import com.emt.lab2.model.dto.AuthorDTO;
import com.emt.lab2.services.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/authors")
public class AuthorController {
    private final AuthorService service;


    public AuthorController(AuthorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Author> findAll(){
        return this.service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable Long id) {
        return this.service.findById(id)
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Author> create(@RequestBody AuthorDTO authorDto) {
        return this.service.create(authorDto)
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<Author> edit(@PathVariable Long id,@RequestBody AuthorDTO authorDto) {
        return this.service.edit(id,authorDto)
                .map(author -> ResponseEntity.ok().body(author))
                .orElseGet(()->ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        this.service.deleteById(id);
        if(this.service.findById(id).isEmpty()) return ResponseEntity.ok().body("Item Deleted");
        return ResponseEntity.badRequest().body("Something went wrong");
    }
}

package com.emt.lab2.services;

import com.emt.lab2.model.domain.Book;
import com.emt.lab2.model.dto.BookDTO;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Optional<Book> findById(Long id);
    List<Book> findAll();
    Optional<Book> create(BookDTO bookDto);
    Optional<Book> edit(Long id,BookDTO bookDto);
    void deleteById(Long id);
    boolean decreaseAvailableCopies(Long id);
}

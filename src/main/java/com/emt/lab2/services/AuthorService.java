package com.emt.lab2.services;

import com.emt.lab2.model.domain.Author;
import com.emt.lab2.model.dto.AuthorDTO;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Optional<Author> findById(Long id);

    List<Author> findAll();

    Optional<Author> create(AuthorDTO authorDTO);

    Optional<Author> edit(Long id, AuthorDTO authorDTO);

    void deleteById(Long id);
}

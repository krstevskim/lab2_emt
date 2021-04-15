package com.emt.lab2.services.impl;

import com.emt.lab2.model.domain.Author;
import com.emt.lab2.model.domain.Country;
import com.emt.lab2.model.dto.AuthorDTO;
import com.emt.lab2.model.exceptions.AuthorNotFoundException;
import com.emt.lab2.model.exceptions.CountryNotFoundException;
import com.emt.lab2.repository.AuthorRepository;
import com.emt.lab2.services.AuthorService;
import com.emt.lab2.services.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository repository;
    private final CountryService countryService;

    public AuthorServiceImpl(AuthorRepository repository, CountryService countryService) {
        this.repository = repository;
        this.countryService = countryService;
    }

    @Override
    public Optional<Author> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Author> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Author> create(AuthorDTO authorDTO) {
        final Author author = new Author();
        final Country country = countryService
                .findById(authorDTO.getCountry()).orElseThrow(() -> new CountryNotFoundException(authorDTO.getCountry()));
        author.setName(authorDTO.getName());
        author.setSurname(authorDTO.getSurname());
        author.setCountry(country);
        return Optional.of(repository.save(author));
    }

    @Override
    public Optional<Author> edit(Long id, AuthorDTO authorDTO) {
        final Author author = repository.findById(id).orElseThrow(() -> new AuthorNotFoundException(id));
        final Country country = countryService
                .findById(authorDTO.getCountry()).orElseThrow(() -> new CountryNotFoundException(authorDTO.getCountry()));
        author.setName(authorDTO.getName());
        author.setSurname(authorDTO.getSurname());
        author.setCountry(country);
        return Optional.of(repository.save(author));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

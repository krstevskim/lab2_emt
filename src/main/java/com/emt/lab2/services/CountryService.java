package com.emt.lab2.services;

import com.emt.lab2.model.domain.Country;
import com.emt.lab2.model.dto.CountryDTO;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    Optional<Country> findById(Long id);

    Optional<Country> findByName(String name);

    List<Country> findAll();

    Optional<Country> save(CountryDTO countryDto);
    Optional<Country> edit(Long id,CountryDTO countryDto);
    void deleteById(Long id);
}

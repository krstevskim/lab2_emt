package com.emt.lab2.services.impl;

import com.emt.lab2.model.domain.Country;
import com.emt.lab2.model.dto.CountryDTO;
import com.emt.lab2.model.exceptions.CountryNotFoundException;
import com.emt.lab2.repository.CountryRepository;
import com.emt.lab2.services.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository repository;

    public CountryServiceImpl(CountryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Country> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Country> findByName(String name) {
        return repository.findCountryByName(name);
    }

    @Override
    public List<Country> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Country> save(CountryDTO countryDto) {
        Country country  = new Country();
        country.setContinent(countryDto.continent);
        country.setName(countryDto.name);
        return Optional.of(this.repository.save(country));
    }

    @Override
    public Optional<Country> edit(Long id, CountryDTO countryDto) {
        Country country = this.repository.findById(id).orElseThrow(()-> new CountryNotFoundException(id));
        country.setName(countryDto.getName());
        country.setContinent(countryDto.getContinent());
        return Optional.of(this.repository.save(country));
    }

    @Override
    public void deleteById(Long id) {
        this.repository.deleteById(id);

    }
}

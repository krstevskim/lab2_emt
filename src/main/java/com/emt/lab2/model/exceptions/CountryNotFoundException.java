package com.emt.lab2.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CountryNotFoundException extends RuntimeException{


    public CountryNotFoundException(Long id) {
        super(String.format("The country with id %d was not found!",id));
    }


    public CountryNotFoundException(String name) {
        super(String.format("The country with name %s was not found!",name));
    }
}

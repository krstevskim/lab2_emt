package com.emt.lab2.model.dto;

public class BookDTO {

    private String name;
    private Integer category;
    private Long author;
    private Integer availableCopies;

    public BookDTO(){}

    public BookDTO(String name,int category,Long author,int availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this. availableCopies = availableCopies;
    }

    public String getName() {
        return name;
    }

    public Integer getCategory() {
        return category;
    }

    public Long getAuthor() {
        return author;
    }

    public Integer getAvailableCopies() {
        return availableCopies;
    }
}

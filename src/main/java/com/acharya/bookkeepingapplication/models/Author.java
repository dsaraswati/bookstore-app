package com.acharya.bookkeepingapplication.models;

import jakarta.persistence.Id;

public class Author {
    private Integer id;
    private String name;

    private String country;

    public Author() {
    }

    public Author(Integer id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public Author(com.acharya.bookkeepingapplication.entity.Author author) {
        this.id = author.getId();
        this.name = author.getName();
        this.country = author.getCountry();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}


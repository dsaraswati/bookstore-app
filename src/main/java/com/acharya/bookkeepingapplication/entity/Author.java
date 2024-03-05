package com.acharya.bookkeepingapplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "author")
public class Author {

    @Id
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

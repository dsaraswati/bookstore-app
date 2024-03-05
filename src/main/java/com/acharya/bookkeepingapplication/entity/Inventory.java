package com.acharya.bookkeepingapplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Inventory {

    @Id
    private Integer bookId;
    private Integer stock;

    public Inventory() {}

    public Inventory(Integer bookId, Integer stock) {
        this.bookId = bookId;
        this.stock = stock;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}

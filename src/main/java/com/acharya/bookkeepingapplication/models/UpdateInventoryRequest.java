package com.acharya.bookkeepingapplication.models;

public class UpdateInventoryRequest {
    private String token;

    private Integer bookId;
    private Integer stock;

    public UpdateInventoryRequest() {}

    public UpdateInventoryRequest(String token, Integer bookId, Integer stock) {
        this.token = token;
        this.bookId = bookId;
        this.stock = stock;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

package com.acharya.bookkeepingapplication.models;

public class Book {

    private Integer id;
    private String title;
    private Author author;
    private String genre;
    private Double price;

    public Book() {}

    public Book(Integer id, String title, Author author, String genre, Double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
    }

    public Book(com.acharya.bookkeepingapplication.entity.Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = new Author(book.getAuthor());
        this.genre = book.getGenre();
        this.price = book.getPrice();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

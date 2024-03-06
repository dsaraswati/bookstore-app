package com.acharya.bookkeepingapplication.entity;

import jakarta.persistence.*;

@Entity(name = "orderhistory")
public class OrderHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookId", referencedColumnName = "id")
    private Book book;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="studentId", referencedColumnName = "id")
    private Student student;

    public OrderHistory() {}

    public OrderHistory(Book book, Student student) {
        this.book = book;
        this.student = student;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}

package com.acharya.bookkeepingapplication.models;

public class CheckoutRequest {

    private Integer bookId;
    private String studentId;

    public CheckoutRequest() {}

    public CheckoutRequest(Integer bookId, String studentId) {
        this.bookId = bookId;
        this.studentId = studentId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}

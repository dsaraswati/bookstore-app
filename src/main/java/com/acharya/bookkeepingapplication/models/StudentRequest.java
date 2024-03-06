package com.acharya.bookkeepingapplication.models;

import jakarta.persistence.Id;

public class StudentRequest {
    private String token;
    private String id;
    private String name;
    private String course;
    private String branch;
    private String aaid;

    public StudentRequest() {}

    public StudentRequest(String token, String id, String name, String course, String branch, String aaid) {
        this.token = token;
        this.id = id;
        this.name = name;
        this.course = course;
        this.branch = branch;
        this.aaid = aaid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAaid() {
        return aaid;
    }

    public void setAaid(String aaid) {
        this.aaid = aaid;
    }
}

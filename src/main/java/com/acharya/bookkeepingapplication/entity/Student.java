package com.acharya.bookkeepingapplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    private String id;
    private String name;
    private String course;
    private String branch;
    private String aaid;

    public Student() {}

    public Student(String id, String name, String course, String branch, String aaid) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.branch = branch;
        this.aaid = aaid;
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
package com.cvaram.blog.beans;

public class Book {
    private int id;

    private String Title;

    private String category;

    private int pages;

    public Book() {
    }

    public Book(int id, String Title, String category, int pages) {
        this.id = id;
        this.Title = Title;
        this.category = category;
        this.pages = pages;
    }

    public String getFirstName() {
        return Title;
    }

    public void setFirstName(String Title) {
        this.Title = Title;
    }

    public String getLastName() {
        return category;
    }

    public void setLastName(String category) {
        this.category = category;
    }

    public int getAge() {
        return pages;
    }

    public void setAge(int pages) {
        this.pages = pages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

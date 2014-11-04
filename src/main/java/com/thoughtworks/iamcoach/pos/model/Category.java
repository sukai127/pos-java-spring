package com.thoughtworks.iamcoach.pos.model;

public class Category {
    private int id;
    private String name;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(){

    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

}

package com.example.myapplication.DATA.Model;
public class Item {
    private int id;
    private String name;
    private String description;
    public Item(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
}
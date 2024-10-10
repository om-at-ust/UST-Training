package com.UST.Learning.Security.entity;


public class Student {

    private String name;
    private int id;
    private String tech;
    public Student() {}

    public Student(String name, int id, String tech) {
        this.name = name;
        this.id = id;
        this.tech = tech;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }


}

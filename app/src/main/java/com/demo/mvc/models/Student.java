package com.demo.mvc.models;
public class Student {
    private int id;
    private String name;
    private String email;
    private  String city;

    public Student(int id, String name, String email, String city){
        this.id = id;
        this.name = name;
        this.email = email;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

}

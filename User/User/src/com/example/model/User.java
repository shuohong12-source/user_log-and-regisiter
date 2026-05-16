package com.example.model;

public class User {
    private  int id;
    private  String phone;
    private  String name;
    private  String password;
    private  String gender;
    private  String role;

    public User() {
    }

    public User(int id, String phone, String name, String password, String gender, String role) {
        this.id = id;
        this.phone = phone;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

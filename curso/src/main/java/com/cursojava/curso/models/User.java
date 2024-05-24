package com.cursojava.curso.models;

public class User{
    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }
    private Long Id;

    private String Name;
    
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getPhone() {
        return Phone;
    }
    public void setPhone(String phone) {
        Phone = phone;
    }
    private String Email;
    private String Phone;
}
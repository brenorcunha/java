package com.cursojava.curso.models;

public class Usuario{
    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }
    private Long Id;

    private String FirstName;
    public String getFirstName() {
        return FirstName;
    }
    public void setFirstName(String firstName) {
        FirstName = firstName;
    }
    public String getLastName() {
        return LastName;
    }
    public void setLastName(String lastName) {
        LastName = lastName;
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
    private String LastName;
    private String Email;
    private String Phone;
}
package com.cursojava.curso.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@ToString @EqualsAndHashCode
public class User{
    //Due to Lombok use: 
    @Id
    @Getter @Setter @Column(name="id")
    private Long Id;

    @Getter @Setter @Column(name="firstName")
    private String FirstName;

    @Getter @Setter @Column (name="lastName")
    private String LastName;

    @Getter @Setter @Column(name="email")
    private String Email;

    @Getter @Setter @Column(name="phone")
    private String Phone;
/* 
    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
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
    } */
}
package com.cursojava.curso.models;

import javax.persistence.*;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@ToString @EqualsAndHashCode
//Due to Lombok use: 
public class User{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter @Setter @Column(name="id")
    private Integer id;

    @Getter @Setter @Column(name="first_name")
    private String FirstName;
    
    @Getter @Setter @Column (name="last_name")
    private String LastName;

    @Getter @Setter @Column(name="email")
    private String Email;

    @Getter @Setter @Column(name="phone")
    private String Phone;

    @Getter @Setter @Column(name="password")
    private String Password;
/* 
    public Long getId() {
        return Id;
    }
    public void setId(Integer id) {
        Id = id;
    }
    
    public String getFirstName() {
        return FirstName;
    }
    public void setFirstName(String first_name) {
        FirstName = first_name;
    }
    public String getLastName() {
        return LastName;
    }
    public void setLastName(String last_name) {
        LastName = last_name;
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
    public User(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    } */
}
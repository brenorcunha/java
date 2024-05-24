package com.cursojava.curso.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.cursojava.curso.models.User;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class UserController {
    @RequestMapping("user/{id}")
    public User getUser(@PathVariable Long id){
        User user = new User();
        user.setId(id);
        user.setName("Breno da Cunha");
        user.setEmail("breno@email.com");
        user.setPhone("08001110000");
        return user;
    }

    @RequestMapping(value = "users")
    public List<User> getUser(){
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setId(123L);
        user.setName("Breno da Cunha");
        user.setEmail("breno@email.com");
        user.setPhone("08001110000");

        User user2 = new User();
        user2.setId(124L);
        user2.setName("Bruno Fontoura");
        user2.setEmail("bruno@email.com");
        user2.setPhone("08001110001");

        User user3 = new User();
        user3.setId(125L);
        user3.setName("Brendon A");
        user3.setEmail("brendon@email.com");
        user3.setPhone("08001110002");
        
        users.add(user);
        users.add(user2);
        users.add(user3);
        return users;
    }

    @RequestMapping(value = "setUser/{id}")
    public User setUser(@PathVariable Long id){
        User user = new User();
        user.setId(id);
        user.setName("Breno da Cunha");
        user.setEmail("breno@email.com");
        user.setPhone("08001110000");
        return user;
    }

    @DeleteMapping("delUser/{id}")
    public User delUser(@PathVariable Long id){
        User user = new User();
        // user.setId(id);
        // user.setName("Breno da Cunha");
        // user.setEmail("breno@email.com");
        // user.setPhone("08001110000");
        return user;
    }
}

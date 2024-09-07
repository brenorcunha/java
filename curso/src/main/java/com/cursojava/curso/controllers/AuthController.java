package com.cursojava.curso.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cursojava.curso.DAO.UserDAO;
import com.cursojava.curso.models.User;
import com.cursojava.curso.utils.JWTUtil;

@RestController
public class AuthController {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private JWTUtil jWTUtil;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public String startSession(@RequestBody User user){
        User loggedUser = userDAO.startSession(user);
        
        if(loggedUser != null){
            String token = jWTUtil.create(String.valueOf(loggedUser.getId()), loggedUser.getEmail());
            return token;
        } else{
            return "Login failed! Try again...";
        }
    }
}
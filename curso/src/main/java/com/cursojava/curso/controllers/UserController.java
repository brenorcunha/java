package com.cursojava.curso.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.cursojava.curso.DAO.UserDAO;
import com.cursojava.curso.models.User;
import com.cursojava.curso.utils.JWTUtil;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@RestController
public class UserController {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private JWTUtil jwtUtil;
    
    @GetMapping(value = "/user/{id}")
    public User getUser(@PathVariable Integer id, @RequestHeader(value="Authorization") String token){
        String usrId = jwtUtil.getKey(token);
        if(usrId == null || usrId.isEmpty()){
            System.out.println("[FAIL] Unsuccessfull login - EMPTY TOKEN");
            return null;}
        else {
        return userDAO.getUser(id);}
        /* User user = new User();
        user.setId(id);
        user.setFirstName("Breno");
        user.setLastName("da Cunha");
        user.setEmail("breno@email.com");
        user.setPhone("08001110000");
        return user; */
    }
    
    @GetMapping("/users")
    public List<User> getUsers(@RequestHeader(value="Authorization") String token){
        //In 'token' variable keeps the token with the user info.

        String usrId = jwtUtil.getKey(token);
        if(usrId == null || usrId.isEmpty()){
            System.out.println("[FAIL] Unsuccessfull login - EMPTY TOKEN");
            return null;}
        else {return userDAO.getUsers();
        }
        /* List<User> users = new ArrayList<>();
        User user = new User();
        user.setId(123);
        user.setFirstName("Breno");
        user.setLastName("da Cunha");
        user.setEmail("breno@email.com");
        user.setPhone("08001110000");

        User user2 = new User();
        user2.setId(124);
        user2.setFirstName("Bruno");
        user2.setLastName("Souza");
        user2.setEmail("bruno@email.com");
        user2.setPhone("08001110001");

        User user3 = new User();
        user3.setId(125);
        user3.setFirstName("Brendon");
        user3.setLastName("Alves");
        user3.setEmail("brendon@email.com");
        user3.setPhone("08001110002");
        
        users.add(user);
        users.add(user2);
        users.add(user3); 
        return users; */
    }

    @PostMapping("/users")
    public void register(@RequestBody User user) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, user.getPassword());
        user.setPassword(hash);
        userDAO.register(user);
    }
    
    @PutMapping("/setUser/{id}")
    public User setUser(@PathVariable Integer id, @RequestBody User updatedUser){
        /* User user = new User();
        user.setId(id);
        user.setFirstName("Breno");
        user.setLastName("da Cunha");
        user.setEmail("breno@email.com");
        user.setPhone("08001110000"); */
        return userDAO.setUser(id, updatedUser);
    }

    @DeleteMapping("/user/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delUser(@RequestHeader(value="Authorization") String token, @PathVariable Integer id){
        String usrId = jwtUtil.getKey(token);
        if(usrId != null){ userDAO.delUser(id);}
        else {return ;}
    }
}
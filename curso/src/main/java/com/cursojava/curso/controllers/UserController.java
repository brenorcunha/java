package com.cursojava.curso.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cursojava.curso.DAO.UserDAO;
import com.cursojava.curso.models.User;

@RestController
public class UserController {
    @Autowired
    private UserDAO userDAO;
    @GetMapping(value = "users/{id}")
    public User getUser(@PathVariable Integer id){
        return userDAO.getUser(id);
        /* User user = new User();
        user.setId(id);
        user.setFirstName("Breno");
        user.setLastName("da Cunha");
        user.setEmail("breno@email.com");
        user.setPhone("08001110000");
        return user; */
    }
    //CONT. DE 3:06h
    @RequestMapping(value="users", method= RequestMethod.GET)
    public List<User> getUsers(){
        return userDAO.getUsers();
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
        user2.setLastName("Fontoura");
        user2.setEmail("bruno@email.com");
        user2.setPhone("08001110001");

        User user3 = new User();
        user3.setId(125);
        user3.setFirstName("Brendon");
        user3.setLastName("A");
        user3.setEmail("brendon@email.com");
        user3.setPhone("08001110002");
        
        users.add(user);
        users.add(user2);
        users.add(user3); 
        return users; */
    }
    @RequestMapping(value="users", method= RequestMethod.POST)
    public void registerUser(@RequestBody User user){
        userDAO.registerUser(user);
    }

    @RequestMapping(value = "setUser/{id}")
    public User setUser(@PathVariable Integer id){
        User user = new User();
        user.setId(id);
        user.setFirstName("Breno");
        user.setLastName("da Cunha");
        user.setEmail("breno@email.com");
        user.setPhone("08001110000");
        return user;
    }

    @RequestMapping(value = "users/{id}", method = RequestMethod.DELETE)
    public void delUser(@PathVariable Integer id){
        userDAO.delUser(id);
    }
}

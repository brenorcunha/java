package com.cursojava.curso.DAO;

import java.util.List;
import com.cursojava.curso.models.User;

public interface UserDAO{
    List<User> getUsers();
    void delUser(Integer id);
    User getUser(Integer id);
    User setUser(Integer id, User updatedUser);
    void register(User user);
};
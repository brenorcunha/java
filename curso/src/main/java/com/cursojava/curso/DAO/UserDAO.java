package com.cursojava.curso.DAO;

import java.util.List;

import com.cursojava.curso.models.User;

public interface UserDAO {
    List<User> getUsers();
    void delUser(Integer id);
}

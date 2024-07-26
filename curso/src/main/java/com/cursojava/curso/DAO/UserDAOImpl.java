package com.cursojava.curso.DAO;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Persistent;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cursojava.curso.models.User;
@Repository
@Transactional
@Persistent
public class UserDAOImpl implements UserDAO{
    @Autowired
    private EntityManager entityManager;
    @SuppressWarnings("unchecked")
    @Override
    public List<User> getUsers(){
        //The class name, not the table name!
        String txt = "SELECT u FROM User";
        Query query = entityManager.createQuery(txt);
        List<User> users_ = query.getResultList();
        if(users_.isEmpty()){
        return Collections.EMPTY_LIST;
        } else {
            return users_;
        }
    };
    @Override
    public void delUser(Integer id){
        User user = entityManager.find(User.class, id);
		entityManager.remove(user);
    };
    @Override
    public User getUser(Integer id) {
        return entityManager.find(User.class, id);
    };
    
    @Override
    public void register(User user) {
       entityManager.merge(user);
    }
    @Override
    public User setUser(Integer id, User updatedUser) {
        return updatedUser;
    };
};
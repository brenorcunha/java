package com.cursojava.curso.DAO;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.annotation.Persistent;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cursojava.curso.models.User;
@Repository
@Transactional
@Persistent
public class UserDAOImpl implements UserDAO{
    @PersistenceContext
    EntityManager entityManager;

    @SuppressWarnings("unchecked")

    @Override
    @Transactional
    public List<User> getUsers(){
        //The class name, not the table name!
        String txt = "FROM User";
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
    public User setUser(Integer id, User updatedUser) {
        return updatedUser;
    }
    // if we insert the attributes inline ('"+ user.email + "') it can be used to make an injection SQL attack! So we do instead: 
    @Override
    public boolean startSession(User user) {
        String txt = "FROM User WHERE email = :email AND password = :password";
        @SuppressWarnings("unchecked")
        List<User> list = entityManager.createQuery(txt).setParameter("email", user.getEmail()).setParameter("password", user.getPassword()).getResultList();
        //The following line is 2 return if the login was successfull: 
        return !list.isEmpty();
    }
    @Override
    @Transactional
    public void register(User user) {
        entityManager.persist(user);
    }
};
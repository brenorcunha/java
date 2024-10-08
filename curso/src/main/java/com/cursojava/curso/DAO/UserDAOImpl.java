package com.cursojava.curso.DAO;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Persistent;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import com.cursojava.curso.models.User;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
@Repository
@Transactional
@Persistent
@RestController
public class UserDAOImpl implements UserDAO{
    @PersistenceContext
    @Autowired
    EntityManager entityManager;

    @SuppressWarnings("unchecked")

    @Override
    @Transactional
    public List<User> getUsers(){
        String txt = "FROM User"; //Class name, not the name of the table.
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
    public User startSession(User user) {
        String txt = "FROM User WHERE email = :email";
        //return !list.isEmpty(); OLD CODE WITHOUT HASHING.

        @SuppressWarnings("unchecked")
        List<User> list = entityManager.createQuery(txt).setParameter("email", user.getEmail()).getResultList();
        if(list.isEmpty()){ return null; }

        String hPassword = list.get(0).getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if(argon2.verify(hPassword, user.getPassword())){
            return list.get(0);
        }
        return null;
    }
    @Override
    @Transactional
    public void register(User user) {
        entityManager.persist(user);
    }
};
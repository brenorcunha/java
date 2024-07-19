package com.cursojava.curso.DAO;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cursojava.curso.models.User;
@Repository
@Transactional
@PersistenceContext
public class UserDAOImpl implements UserDAO{
    private EntityManager entityManager;
    @SuppressWarnings("unchecked")
    @Override
    public List<User> getUsers(){
       try {
        String query = "SELECT * FROM User"; //The class name, not the table name!
        return entityManager.createQuery(query).getResultList();
       } catch (Exception e) {
        return Collections.EMPTY_LIST;
       }
    };
    @Override
    public void delUser(Integer id){
        User user = entityManager.find(User.class, id);
		entityManager.remove(user);
    }
    @Override
    public User getUser(Integer id) {
        return entityManager.find(User.class, id);
    }
    
    @Override
    public void registerUser(User user) {
       entityManager.merge(user);
    };

}

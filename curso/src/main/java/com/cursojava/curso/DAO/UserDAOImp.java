package com.cursojava.curso.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cursojava.curso.models.User;
@Repository
@Transactional
@PersistenceContext
public class UserDAOImp implements UserDAO {
    private EntityManager entityManager;
    @SuppressWarnings("unchecked")
    @Override
    public List<User> getUsers() {
        String query = "FROM User";
        return entityManager.createQuery(query).getResultList();
    }
    
}

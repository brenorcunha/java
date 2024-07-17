package com.cursojava.curso.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cursojava.curso.models.User;
@Repository
@Transactional
@PersistenceContext
public class UserDAOImpl implements UserDAO{
    private EntityManager entityManager;
    @SuppressWarnings("unchecked")
    @Override
    public List<User> getUsers(){
        String query = "FROM users";
        return entityManager.createQuery(query).getResultList();
    };
    @Override
    public void delUser(Integer id){
        User user = entityManager.find(User.class, id);
		entityManager.remove(user);
    };

}

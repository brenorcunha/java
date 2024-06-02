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
public class UserDAOImpl implements UserDAO {
    private EntityManager entityManager;
    @SuppressWarnings("unchecked")
    @Override
    public List<User> getUsers() {
        String query = "FROM User";
        return entityManager.createQuery(query).getResultList();
    }
    @Override
	public void delUser(Integer id){
		User user = entityManager.find(User.class, id);
		entityManager.remove(user);
	}
}

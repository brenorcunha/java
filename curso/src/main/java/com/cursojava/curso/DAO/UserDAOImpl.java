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
        final String txt = "FROM User";
        final Query query = entityManager.createQuery(txt);
        final List<User> users_ = query.getResultList();
        if(users_.isEmpty()){
        return Collections.EMPTY_LIST;
        } else {
            return users_;
        }
    };
    @Override
    public void delUser(final Integer id){
        final User user = entityManager.find(User.class, id);
		entityManager.remove(user);
    };
    @Override
    public User getUser(final Integer id) {
        return entityManager.find(User.class, id);
    };
    
    @Override
    public void register(final User user) {
       entityManager.merge(user);
    }
    @Override
    public User setUser(final Integer id, final User updatedUser) {
        return updatedUser;
    };
};
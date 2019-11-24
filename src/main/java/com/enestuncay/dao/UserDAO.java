package com.enestuncay.dao;

import com.enestuncay.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    //insert user into database
    public void insert(User user){
        sessionFactory.getCurrentSession().save(user);
    }

    //update existing user
    public void update(User user)
    {
        sessionFactory.getCurrentSession().update(user);
    }

    //delete user
    public void delete(User user){sessionFactory.getCurrentSession().delete(user);}

    //read user by CustomerId and Password
    public User getUser(String customerId , String password){
        Query query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE customerId=:customerId AND hashPassword=:password")
                .setString("customerId",customerId)
                .setString("password" , password);

        User user = null;
        try{
            user = (User) query.getSingleResult();
        }catch (javax.persistence.NoResultException e) {
            user = null;
        }
        return user;
    }

    //read user by CustomerId
    public User getUser(String customerId){
        Query query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE customerId=:customerId")
                .setString("customerId", customerId);

        User user = null;
        try{
            user = (User) query.getSingleResult();
        }catch (javax.persistence.NoResultException e) {
            user = null;
        }
        return user;
    }


}

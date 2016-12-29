package com.kozlov.dao;


import com.kozlov.entity.UserEntity;
import com.kozlov.hibernate.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;


public class UserDAOImpl extends GenericDAOImpl<UserEntity> {
    public UserEntity getUserByName(String username) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from UserEntity where name=:name ");
        query.setParameter("name", username);
        UserEntity userEntity = (UserEntity) query.uniqueResult();
        session.getTransaction().commit();
        return userEntity;
    }

}

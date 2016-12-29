package com.kozlov.dao;

import com.kozlov.entity.FriendEntity;
import com.kozlov.hibernate.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;


public class FriendDAOImpl extends GenericDAOImpl<FriendEntity> implements FriendDAO {


    public void removeFriend(String username, String friend) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("delete FriendEntity where username = :username And friend=:friend");
        query.setParameter("username", username);
        query.setParameter("friend", friend.trim());
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    public List<FriendEntity> getListFriendByName(String username) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from FriendEntity where username=:login ");
        query.setParameter("login", username);
        List<FriendEntity> friendEntities = query.list();
        session.getTransaction().commit();
        return friendEntities;
    }


}

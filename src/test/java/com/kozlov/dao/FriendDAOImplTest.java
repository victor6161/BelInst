package com.kozlov.dao;

import com.kozlov.entity.FriendEntity;
import com.kozlov.hibernate.HibernateTest;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;


public class FriendDAOImplTest {
    private FriendEntity friendEntity;
    private Session session;
    private final String testName = "testlogin";

    @Before
    public void setUp() throws Exception {
        session = HibernateTest.getSessionFactory().openSession();
        friendEntity = new FriendEntity();
        friendEntity.setFriend(testName);
        friendEntity.setUsername(testName);
        session.save(friendEntity);
    }

    @After
    public void tearDown() throws Exception {
        session.close();
    }

    @Test
    @Transactional
    @Rollback(true)
    public void removeFriend() throws Exception {

        Query query = session.createQuery("delete FriendEntity where username = :username And friend=:friend");
        query.setParameter("username", testName);
        query.setParameter("friend", testName);
        Query queryTest = session.createQuery("from FriendEntity where username=:login ");
        queryTest.setParameter("login", testName);
        List<FriendEntity> friendEntities = queryTest.list();
        assertTrue(friendEntities.isEmpty());
    }

}
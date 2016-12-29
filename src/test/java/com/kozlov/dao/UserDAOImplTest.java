package com.kozlov.dao;

import com.kozlov.entity.UserEntity;
import com.kozlov.hibernate.HibernateTest;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertTrue;


public class UserDAOImplTest {
    private UserEntity userEntity;
    private Session session;
    private final String name = "lelik";
    private final String password = "123";
    private final String role = "ROLE_ADMIN";
    private final String email = "lelik@mail.ru";

    @Before
    public void setUp() throws Exception {
        userEntity = new UserEntity();
        userEntity.setName(name);
        userEntity.setPassword(password);
        userEntity.setRole(role);
        userEntity.setEmail(email);
        session = HibernateTest.getSessionFactory().openSession();
    }

    @Test
    @Transactional
    @Rollback(true)
    public void getUserByName() throws Exception {
        session.beginTransaction();
        session.save(userEntity);
        Query query = session.createQuery("from UserEntity where name=:name ");
        query.setParameter("name", name);
        UserEntity userEntityTest = (UserEntity) query.uniqueResult();
        assertTrue(userEntity.equals(userEntityTest));
    }

    public void tearDown() throws Exception {
        session.close();
    }

}
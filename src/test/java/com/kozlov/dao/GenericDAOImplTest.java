package com.kozlov.dao;

import com.kozlov.entity.UserEntity;
import com.kozlov.hibernate.HibernateTest;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertTrue;


public class GenericDAOImplTest {
    private final String name="name";
    private final String  password="123";
    private final String fullName="asd";
    private final String role="ROLE_ADMIN";
    private final String email="dsf@ee.com";
    UserEntity userEntity;
    Session session;
    @Before
    public void setUp() throws Exception {
        userEntity=new UserEntity();
        userEntity.setName(name);
        userEntity.setPassword(password);
        userEntity.setFullName(fullName);
        userEntity.setRole(role);
        userEntity.setEmail(email);
        session = HibernateTest.getSessionFactory().openSession();
    }

    @After
    public void tearDown() throws Exception {
        session.close();
    }

    @Test
    @Transactional
    @Rollback(true)
    public void save() throws Exception {
        session.beginTransaction();

        session.save(userEntity);
        session.getTransaction().commit();
        Query query = session.createQuery("from UserEntity where name=:name ");
        query.setParameter("name", name);
        UserEntity userEntityTest = (UserEntity) query.uniqueResult();
        assertTrue(userEntity.equals(userEntityTest));
    }
}

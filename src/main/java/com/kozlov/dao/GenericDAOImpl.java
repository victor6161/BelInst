package com.kozlov.dao;


import com.kozlov.hibernate.HibernateSessionFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;


public abstract class GenericDAOImpl<T> implements GenericDAO<T> {

    public void delete(final T o) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
    }

    public void save(final T o) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
    }

    public List<T> getList(final Class clazz) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        List<T> list = session.createCriteria(clazz).list();
        session.getTransaction().commit();
        return list;
    }

    public List<T> getListByParameter(final Class clazz, String key, String value) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        List list = session.createCriteria(clazz).add(Restrictions.eq(key, value)).addOrder(Order.desc("date")).list();
        session.getTransaction().commit();
        return list;
    }
}

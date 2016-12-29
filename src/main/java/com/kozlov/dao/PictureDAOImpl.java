package com.kozlov.dao;


import com.kozlov.entity.PictureEntity;
import com.kozlov.hibernate.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import java.util.List;


public class PictureDAOImpl extends GenericDAOImpl<PictureEntity> {

    public List<PictureEntity> getList() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        List<PictureEntity> list = session.createCriteria(PictureEntity.class).addOrder(Order.desc("date")).list();
        session.getTransaction().commit();
        return list;
    }

    public PictureEntity getPictureById(Integer id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from PictureEntity where id=:id ");
        query.setParameter("id", id);
        PictureEntity userEntity = (PictureEntity) query.uniqueResult();
        session.getTransaction().commit();
        return userEntity;
    }

}

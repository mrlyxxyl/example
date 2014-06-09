package com.yuexin.dao.impl;

import com.yuexin.bean.Student;
import com.yuexin.dao.PersonDao;
import com.yuexin.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PersonDaoImpl implements PersonDao {
    @Override
    public void save(Student person) {
        Session session = null;
        Transaction transaction;
        try {
            session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            session.save(person);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}

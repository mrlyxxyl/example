package com.yuexin.dao;

import com.yuexin.bean.Person;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Repository
@Transactional
public class PersonDao {

    @Resource
    private SessionFactory sessionFactory;

    public void save(Person person) {
        sessionFactory.getCurrentSession().save(person);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<Person> getPersons() {
        List<Person> list = sessionFactory.getCurrentSession().createQuery("from Person").list();
        return list;
    }
}

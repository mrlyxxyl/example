package com.yuexin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yuexin.bean.Person;
import com.yuexin.service.PersonService;

@Transactional
public class PersonServiceBean implements PersonService {

    @Resource
    private SessionFactory sessionFactory;

    public void save(Person person) {
        sessionFactory.getCurrentSession().persist(person);
    }

    public void delete(int id) {
        sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().load(Person.class, id));

    }

    public void update(Person person) {
        sessionFactory.getCurrentSession().update(person);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Person getPerson(int id) {
        Person person = (Person) sessionFactory.getCurrentSession().get(Person.class, id);
        return person;
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<Person> getPersons() {
        String sql = "from Person as person";
        Query query = sessionFactory.getCurrentSession().createQuery(sql);
        List<Person> list = query.list();
        return list;
    }

}

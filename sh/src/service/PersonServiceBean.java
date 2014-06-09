package service;

import bean.Person;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class PersonServiceBean {
    @Resource
    private SessionFactory sessionFactory;

    public void save(Person person) {
        sessionFactory.getCurrentSession().save(person);
    }
}

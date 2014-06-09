package com.yuexin.service;

import com.yuexin.bean.Person;
import com.yuexin.dao.PersonDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PersonService {
    @Resource
    private PersonDao personDao;

    public void savePerson(Person person) {
        personDao.save(person);
    }

    public List<Person> getPersons() {
        return personDao.getPersons();
    }
}

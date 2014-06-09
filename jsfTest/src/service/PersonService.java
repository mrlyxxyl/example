package service;

import dao.PersonDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PersonService {
//    @Resource
    @Resource
    private PersonDao personDao;

    public void add() {
        personDao.save();
    }

    public PersonDao getPersonDao() {
        return personDao;
    }

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }
}

package com.yuexin.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yuexin.dao.PersonDao;
import com.yuexin.service.PersonService;

@Service
public class PersonServiceBean implements PersonService {

    @Resource
    private PersonDao personDao;
    private String name = "fsadfsda";

    public PersonServiceBean() {
    }

    @Override
    public void save() {
        personDao.add();
        System.out.println(name);
    }
}

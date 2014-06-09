package com.yuexin.dao.impl;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.yuexin.dao.PersonDao;

@Repository("personDao")
public class PersonDaoImpl implements PersonDao {

	@Override
	public void add() {
		System.out.println("add()");
	}

	@PostConstruct
	public void init() {
		System.out.println("≥ı ºªØ");
	}

}

package com.yuexin.service.impl;

import com.yuexin.service.PersonService;

public class PersonServiceImpl implements PersonService {

	@Override
	public void save() {
		System.out.println("save()");
	}

	@Override
	public void update(String name, Integer id) {
		System.out.println("update");
	}

	@Override
	public String getPersonName(Integer id) {
		return "nanmeiying";
	}

}

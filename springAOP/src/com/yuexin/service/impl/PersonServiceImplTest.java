package com.yuexin.service.impl;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yuexin.service.PersonService;

public class PersonServiceImplTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testSave() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		PersonService personService = (PersonService) applicationContext.getBean("personService");
		personService.save();
	}

	@Test
	public void testUpdate() {
	}

	@Test
	public void testGetPersonName() {
	}

}

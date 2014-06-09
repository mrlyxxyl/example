package com.yuexin.service.impl;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yuexin.bean.Person;
import com.yuexin.service.PersonService;

public class PersonServiceBeanTest {
	
	private static PersonServiceBean personService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		personService = (PersonServiceBean) context.getBean("personService");
	}

	@Test
	public void testSave() {	
		personService.save(new Person("fdsafjdsjflksd"));
	}

	@Test
	public void testDelete() {
		personService.delete(4);
	}

	@Test
	public void testUpdate() {
		Person person = personService.getPerson(3);
		person.setName("ddddddddd");
		personService.update(person);
	}

	@Test
	public void testGetPerson() {
		Person person= personService.getPerson(5);
		System.out.println(person.getName());
	}

	@Test
	public void testGetPersons() {
		List<Person> list = personService.getPersons();
		for (Person person : list) {
			System.out.println(person.getName());
		}
	}

}

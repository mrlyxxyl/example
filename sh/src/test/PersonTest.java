package test;

import bean.Person;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.PersonServiceBean;

public class PersonTest {

    private static PersonServiceBean personServiceBean;

    @BeforeClass
    public static void setBeforeClass() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        personServiceBean = (PersonServiceBean) context.getBean("personServiceBean");
    }

    @Test
    public void testSave() {
        Person person = new Person();
        person.setName("nanmeiying");
        personServiceBean.save(person);
    }
}

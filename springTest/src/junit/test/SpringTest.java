package junit.test;

import com.yuexin.service.impl.PersonServiceBean;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yuexin.service.PersonService;

public class SpringTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		PersonServiceBean personServiceBean = (PersonServiceBean) applicationContext.getBean("personServiceBean");
        personServiceBean.save();
	}

}

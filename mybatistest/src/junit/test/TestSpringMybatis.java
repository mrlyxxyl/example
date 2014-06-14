package junit.test;

import com.yuexin.bean.User;
import com.yuexin.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringMybatis {
    @Test
    public void testSpring() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        SqlSessionFactory factory = (SqlSessionFactory) ac.getBean("sqlSessionFactory");
        SqlSession sqlSession = factory.openSession();
        User user = sqlSession.selectOne("getUserById2", 4);
        System.out.println(user.getName());
    }

    @Test
    public void testSpring2() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService service = (UserService) ac.getBean("userService");
        User user = service.getUser();
        System.out.println(user.getName());
    }

}

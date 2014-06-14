package junit.test;

import com.yuexin.bean.User;
import com.yuexin.dao.User2Dao;
import com.yuexin.dao.UserDao;
import com.yuexin.dao.impl.UserDaoImpl;
import com.yuexin.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestUser {
    @Test
    public void testInsert() {
        User user = new User();
        user.setName("nanmeiying");
        user.setFirstName("firstName");
        UserDao dao = new UserDaoImpl();
        int nu = dao.insert(user);
        System.out.println(nu);
    }

    @Test
    public void testFind() {
        UserDao dao = new UserDaoImpl();
        User user = dao.getUserById(1);
        System.out.println(user.getFirstName());
    }

    @Test
    public void testUpdate() {
        UserDao dao = new UserDaoImpl();
        User user = new User();
        user.setId(1);
        user.setName("hahhahahaha");
        user.setFirstName("scejfdlksjlkfds");
        int dd = dao.updateUser(user);
        System.out.println(dd);
    }

    @Test
    public void testDelete() {
        UserDao dao = new UserDaoImpl();
        int num = dao.deleteUser(4);
        System.out.println(num);
    }

    @Test
    public void testGetUsers() {
        UserDao dao = new UserDaoImpl();
        List<User> users = dao.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testMapper() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> users = userDao.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testDao2() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        User2Dao dao = sqlSession.getMapper(User2Dao.class);
        User user = dao.getUserById2(9);
        System.out.println(user.getName());


    }
}

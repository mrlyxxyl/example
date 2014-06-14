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
        UserDao dao = new UserDaoImpl();
        int nu = dao.insert(user);
        System.out.println(nu);
    }

    @Test
    public void testFind() {
        UserDao dao = new UserDaoImpl();
        User user = dao.getUserById(3);
        System.out.println(user.getName());
    }

    @Test
    public void testUpdate() {
        UserDao dao = new UserDaoImpl();
        User user = new User();
        user.setId(4);
        user.setName("eeeee");
        int dd = dao.updateUser(user);
        System.out.println(dd);
    }

    @Test
    public void testDelete() {
        UserDao dao = new UserDaoImpl();
        int num = dao.deleteUser(12);
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
        User2Dao user2Dao = sqlSession.getMapper(User2Dao.class);
        User user = user2Dao.getUserById2(9);
        System.out.println(user.getName());
    }

}

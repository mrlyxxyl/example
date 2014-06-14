package com.yuexin.dao.impl;

import com.yuexin.bean.User;
import com.yuexin.dao.UserDao;
import com.yuexin.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private SqlSession sqlSession = MyBatisUtil.getSqlSession();

    public int insert(User user) {
        int num = sqlSession.insert("insert", user);
        sqlSession.commit();
        return num;
    }

    public User getUserById(int id) {
        User user = (User) sqlSession.selectOne("getUserById", id);
        return user;
    }

    public int updateUser(User user) {
        int num = sqlSession.update("updateUser", user);
        sqlSession.commit();
        return num;
    }

    public int deleteUser(int id) {
        int num = sqlSession.delete("deleteUser", id);
        sqlSession.commit();
        return num;
    }

    public List<User> getUsers() {
        List<User> users = sqlSession.selectList("getUsers");
        return users;
    }
}

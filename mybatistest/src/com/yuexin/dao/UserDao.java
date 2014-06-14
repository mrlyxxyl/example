package com.yuexin.dao;

import com.yuexin.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserDao {
    /**
     * 增加user
     * @param user
     */
    int insert(User user);

    /**
     * 查
     * @param id
     * @return
     */
    User getUserById(int id);

    /**
     * 改
     * @param user
     */
    int updateUser(User user);

    /**
     * 删
     * @param id
     */
    int deleteUser(int id);


    List<User> getUsers();
}

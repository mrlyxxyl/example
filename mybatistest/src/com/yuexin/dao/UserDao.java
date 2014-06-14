package com.yuexin.dao;

import com.yuexin.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserDao {
    /**
     * ����user
     * @param user
     */
    int insert(User user);

    /**
     * ��
     * @param id
     * @return
     */
    User getUserById(int id);

    /**
     * ��
     * @param user
     */
    int updateUser(User user);

    /**
     * ɾ
     * @param id
     */
    int deleteUser(int id);


    List<User> getUsers();
}

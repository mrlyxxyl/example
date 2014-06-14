package com.yuexin.service;

import com.yuexin.bean.User;
import com.yuexin.dao.User2Dao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private User2Dao user2Dao;

    public User getUser() {
        User user = user2Dao.getUserById2(4);
        return user;
    }
}

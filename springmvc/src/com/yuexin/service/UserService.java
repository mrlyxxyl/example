package com.yuexin.service;

import com.yuexin.bean.User;
import com.yuexin.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-9-26
 * Time: 上午8:27
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserService {

    @Resource
    private UserDao userDao;

    public boolean existsUser(User user) {
        int num = userDao.findUser(user);
        if (num == 1) {
            return true;
        }
        return false;
    }
}

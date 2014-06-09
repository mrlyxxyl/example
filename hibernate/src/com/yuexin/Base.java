package com.yuexin;

import com.yuexin.bean.User;
import com.yuexin.dao.UserDao;
import com.yuexin.dao.impl.UserDaoImpl;

import java.util.Date;


public class Base {

	public static void main(String[] args) {
		UserDao userDao = new UserDaoImpl();
		User user = new User();
        user.setBirthday(new Date());
        user.setName("nanmeiying");
		userDao.insert(user);
	}
}

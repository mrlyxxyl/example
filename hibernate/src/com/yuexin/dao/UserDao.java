package com.yuexin.dao;

import java.util.List;

import com.yuexin.bean.User;

public interface UserDao {

	public void insert(User user);
	
	public void delete(User user);
	
	public void update(User user);
	
	public User selectUserById(int id);
	
	public List<User> getUsers();
}

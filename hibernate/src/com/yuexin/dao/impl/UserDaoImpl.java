package com.yuexin.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yuexin.bean.User;
import com.yuexin.dao.UserDao;
import com.yuexin.util.HibernateUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public void insert(User user) {
		Session session = null;
		Transaction transaction;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
		} catch (HibernateException e) {
			session.close();
		}
	}

	@Override
	public void delete(User user) {
		Session session = null;
		Transaction transaction;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			try {
				session.delete(user);
			} catch (Exception e) {
				System.out.println("对象为空！！");
			}
			transaction.commit();
		} catch (HibernateException e) {
			session.close();
		}
	}

	@Override
	public void update(User user) {
		Session session = null;
		Transaction transaction;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			try {
				session.update(user);
			} catch (Exception e) {
				System.out.println("对象为空！！！");
			}
			transaction.commit();
		} catch (HibernateException e) {
			session.close();
		}

	}

	@Override
	public User selectUserById(int id) {
		Session session = null;
		User user = null;
		try {
			session = HibernateUtil.getSession();
			user = (User) session.get(User.class, id);
		} catch (HibernateException e) {
			session.close();
		}
		return user;
	}

	@Override
	public List<User> getUsers() {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("from User as user");
		@SuppressWarnings("unchecked")
		List<User> list = query.list();
		session.close();
		return list;
	}

}

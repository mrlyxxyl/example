package com.yuexin.util;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new Configuration().configure()
					.buildSessionFactory();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session getSession() {
		return sessionFactory.openSession();
	}
}
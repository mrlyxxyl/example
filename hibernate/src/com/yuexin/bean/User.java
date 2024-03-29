package com.yuexin.bean;

import java.util.Date;

public class User {
	private int id;
	private String name;
	private Date birthday;

	public User() {
	}

	public User(String name, Date birthday) {
		this.name = name;
		this.birthday = birthday;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}

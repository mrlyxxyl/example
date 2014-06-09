package com.yuexin.service;

public interface PersonService {
	public void save();

	public void update(String name, Integer id);

	public String getPersonName(Integer id);
}

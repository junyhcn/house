package com.dao;

import java.io.Serializable;
import java.util.List;

import com.entity.User;

public interface UserDao {
	public List<User> findAll();
	public User login(String name,String pwd);
	public Serializable  save(User user);
}

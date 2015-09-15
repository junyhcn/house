package com.dao;

import java.util.List;

import com.entity.Type;

public interface TypeDao {
	public Type findById(int id);
	public List<Type> findAll();
}

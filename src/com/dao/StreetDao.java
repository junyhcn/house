package com.dao;

import java.util.List;

import com.entity.Street;

public interface StreetDao {
	public Street findById(int id);
	public List<Street> findAll();
}

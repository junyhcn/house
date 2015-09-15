package com.dao;

import java.io.Serializable;
import java.util.List;

import com.entity.House;
import com.entity.HouseCondition;

public interface HouseDao {
	public List<House> findAll();

	public Serializable save(House house);

	public List<House> findAll(HouseCondition condition);
}

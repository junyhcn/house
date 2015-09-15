package com.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.dao.HibernateSessionFactory;
import com.dao.StreetDao;
import com.entity.Street;
import com.entity.Type;

public class StreetDaoImpl implements StreetDao {

	@Override
	public Street findById(int id) {
		Session session = HibernateSessionFactory.getSession();
		Street street = (Street) session.get(Street.class, id);
		session.close();
		return street;
	}

	@Override
	public List<Street> findAll() {
		Session session = HibernateSessionFactory.getSession();
		String hql = "from Street";
		List<Street> list = session.createQuery(hql).list();
		session.close();
		return list;
	}

}

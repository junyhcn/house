package com.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.dao.HibernateSessionFactory;
import com.dao.TypeDao;
import com.entity.Type;

public class TypeDaoImpl implements TypeDao {

	@Override
	public Type findById(int id) {
		Session session = HibernateSessionFactory.getSession();
		Type type = (Type) session.get(Type.class, id);
		session.close();
		return type;
	}

	@Override
	public List<Type> findAll() {
		Session session = HibernateSessionFactory.getSession();
		String hql = "from Type";
		List<Type> list = session.createQuery(hql).list();
		session.close();
		return list;
	}

}

package com.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dao.HibernateSessionFactory;
import com.dao.UserDao;
import com.entity.User;

public class UserDaoImpl implements UserDao {

	@Override
	public List<User> findAll() {
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from User");
		List<User> list = query.list();
		session.close();
		return list;
	}

	@Override
	public User login(String name, String pwd) {
		Session session = HibernateSessionFactory.getSession();
		String hql = "from User where name=? and password=?";
		Query query = session.createQuery(hql);
		query.setString(0, name);
		query.setString(1, pwd);
		User user = (User) query.uniqueResult();
		session.close();
		/*
		 * List<User> list = query.list(); session.close(); if (list.size() > 0)
		 * return list.get(0); else return null;
		 */
		return user;
	}

	@Override
	public Serializable save(User user) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		Serializable id = session.save(user);
		tx.commit();
		session.close();
		return id;
	}
}

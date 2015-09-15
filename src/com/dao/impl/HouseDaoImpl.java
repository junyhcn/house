package com.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dao.HibernateSessionFactory;
import com.dao.HouseDao;
import com.entity.House;
import com.entity.HouseCondition;

public class HouseDaoImpl implements HouseDao {

	@Override
	public List<House> findAll() {
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from House");
		List<House> list = query.list();
		// session.close();
		return list;
	}

	@Override
	public Serializable save(House house) {
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		Serializable id = session.save(house);
		tx.commit();
		session.close();
		return id;
	}

	@Override
	public List<House> findAll(HouseCondition condition) {
		String hql = "from House h where 1=1";
		if (condition.getType_id() != -1) {
			hql = hql + " and h.type.id=:tid";
		}
		if (condition.getStreet_id() != -1) {
			hql = hql + " and h.street.id=:sid";
		}
		if (condition.getLprice() != 0 && condition.getHprice() != 0) {
			hql = hql + " and h.price>:lprice and h.price<:hprice";
		}
		if (condition.getFloorage() != 0) {
			hql = hql + "  and h.floorage=:floor";
		}
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery(hql);
		if (condition.getType_id() != -1) {
			query.setInteger("tid", condition.getType_id());
		}
		if (condition.getStreet_id() != -1) {
			query.setInteger("sid", condition.getStreet_id());
		}
		if (condition.getLprice() != 0 && condition.getHprice() != 0) {
			query.setInteger("lprice", condition.getLprice());
			query.setInteger("hprice", condition.getHprice());
		}
		if (condition.getFloorage() != 0) {
			query.setInteger("floor", condition.getFloorage());
		}
		List<House> list = query.list();
		return list;
	}

}

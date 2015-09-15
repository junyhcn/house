package com.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.dao.HouseDao;
import com.dao.StreetDao;
import com.dao.TypeDao;
import com.dao.impl.HouseDaoImpl;
import com.dao.impl.StreetDaoImpl;
import com.dao.impl.TypeDaoImpl;
import com.entity.House;
import com.entity.HouseCondition;
import com.entity.Street;
import com.entity.Type;
import com.entity.User;
import com.opensymphony.xwork2.ActionContext;

public class HouseAction {
	// 为addHouse.jsp提供数据[type/street]
	private TypeDao typeDao = new TypeDaoImpl();
	private StreetDao streetDao = new StreetDaoImpl();
	private HouseDao houseDao = new HouseDaoImpl();

	private String title;
	private double price;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	public int getStreet_id() {
		return street_id;
	}

	public void setStreet_id(int street_id) {
		this.street_id = street_id;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public int getFloorage() {
		return floorage;
	}

	public void setFloorage(int floorage) {
		this.floorage = floorage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private int type_id;
	private int street_id;
	private String contact;
	private int floorage;
	private String description;
	private int lprice;
	private int hprice;

	public int getLprice() {
		return lprice;
	}

	public void setLprice(int lprice) {
		this.lprice = lprice;
	}

	public int getHprice() {
		return hprice;
	}

	public void setHprice(int hprice) {
		this.hprice = hprice;
	}

	public String init() {
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		User user = (User) session.get("user");
		if (user != null) {
			Map request = (Map) ac.get("request");

			List<Type> tlist = typeDao.findAll();
			List<Street> slist = streetDao.findAll();

			request.put("tlist", tlist);
			request.put("slist", slist);

			return "addHouse";
		} else
			return "login";
	}

	public String add() {
		House house = new House();

		house.setTitle(title);
		house.setContact(contact);
		house.setDescription(description);
		house.setFloorage(floorage);
		house.setPrice(price);

		house.setType(typeDao.findById(type_id));
		house.setStreet(streetDao.findById(street_id));

		// 发布日期为今天
		house.setDate(new Date());
		// 当前登录的用户是发布人
		ActionContext ac = ActionContext.getContext();
		User user = (User) ac.getSession().get("user");
		house.setUser(user);

		houseDao.save(house);
		return list();
	}

	/**
	 * 显示所有房子
	 * 
	 * @return
	 */
	public String list() {
		ActionContext ac = ActionContext.getContext();

		Map request = (Map) ac.get("request");

		List<Type> tlist = typeDao.findAll();
		List<Street> slist = streetDao.findAll();

		request.put("tlist", tlist);
		request.put("slist", slist);

		List<House> list = houseDao.findAll();
		Map req = (Map) ac.get("request");
		req.put("hlist", list);
		return "listhouse";

	}

	public String query() {
		ActionContext ac = ActionContext.getContext();

		Map request = (Map) ac.get("request");
		HouseCondition condition = new HouseCondition();
		condition.setStreet_id(street_id);
		condition.setType_id(type_id);
		condition.setLprice(lprice);
		condition.setHprice(hprice);
		condition.setFloorage(floorage);
		List<Type> tlist = typeDao.findAll();
		List<Street> slist = streetDao.findAll();

		request.put("tlist", tlist);
		request.put("slist", slist);

		List<House> list = houseDao.findAll(condition);
		Map req = (Map) ac.get("request");
		req.put("hlist", list);
		return "listhouse";

	}
}

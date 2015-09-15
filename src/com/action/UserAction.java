package com.action;

import java.io.Serializable;
import java.util.Map;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.entity.User;
import com.opensymphony.xwork2.ActionContext;

public class UserAction {
	private String name;
	private String pwd;
	private String userName;
	private String telephone;
	private String admin;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	private UserDao userDao = new UserDaoImpl();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String login() {
		User user = userDao.login(name, pwd);
		ActionContext ac = ActionContext.getContext();
		Map session=ac.getSession();
		if (user != null) {
			session.put("user", user);
			Map map = (Map) ac.get("request");
			map.put("list", userDao.findAll());
			return "success";  //list.jsp
		} else {
			return "login";
		}
	}

	public String add() {
		User user = new User();
		user.setName(name);
		user.setPassword(pwd);
		user.setIsAdmin(admin);
		user.setTelephone(telephone);
		user.setUserName(userName);
		Serializable id = userDao.save(user);
		if (id != null) {
			return "success";//list.jsp
		} else {
			return "error";//error.jsp
		}
	}
}

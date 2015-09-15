package com.action;

import com.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MyAction extends ActionSupport implements ModelDriven<User> {
    private User user=new User();
	@Override
	public User getModel() {
		
		return user;
	}
	public String list(){
		System.out.println(this.user.getName());
		return SUCCESS;
	}

}

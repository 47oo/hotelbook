package com.hotel.userdaotest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hotel.base.BaseJUnit;
import com.hotel.dao.UserDAO;
import com.hotel.model.User;

public class TestUserDao extends BaseJUnit{
	@Autowired
	private UserDAO iu;
	@Test
	public void test(){
		User u = new User();
		u.setName("1234");
		u.setPassword("1234");
		iu.checkUser(u);
	}
}

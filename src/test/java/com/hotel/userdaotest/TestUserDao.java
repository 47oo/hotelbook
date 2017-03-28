package com.hotel.userdaotest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hotel.base.BaseJUnit;
import com.hotel.dao.IUserDAO;
import com.hotel.domain.User;

public class TestUserDao extends BaseJUnit{
	@Autowired
	private IUserDAO iu;
	@Test
	public void test(){
		User u = new User();
		u.setName("1234");
		u.setPassword("1234");
		System.out.println(iu.hasUser(u));
	}
}

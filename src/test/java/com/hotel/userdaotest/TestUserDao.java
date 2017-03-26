package com.hotel.userdaotest;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hotel.base.BaseJUnit;
import com.hotel.dao.IUserDAO;

public class TestUserDao extends BaseJUnit{
	@Autowired
	private IUserDAO iu;
	@Test
	public void test(){
		System.out.println("=======");
		List<Integer> l = iu.getId();
		System.out.println(l.size());
	}
}

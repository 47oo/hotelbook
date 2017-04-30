package com.hotel.userdaotest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hotel.base.BaseJUnit;
import com.hotel.dao.UserDAO;

public class TestUserDao extends BaseJUnit{
	@Autowired
	private UserDAO iu;
	@Test
	public void test() throws NoSuchAlgorithmException{
//		User u = new User();
//		u.setName("1234");
//		u.setPassword("1234");
//		iu.checkUser(u);
		MessageDigest mdInst = MessageDigest.getInstance("MD5");

		System.out.println(Hex.encodeHex(mdInst.digest("1234".getBytes())));
	}
}

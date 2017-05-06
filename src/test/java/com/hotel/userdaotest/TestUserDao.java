package com.hotel.userdaotest;

import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hotel.base.BaseJUnit;
import com.hotel.dao.RoomDAO;
import com.hotel.dao.UserDAO;
import com.hotel.model.Room;

public class TestUserDao extends BaseJUnit{
	@Autowired
	private UserDAO iu;
	@Autowired
	private RoomDAO rd;
	@Test
	public void test() throws NoSuchAlgorithmException{
//		User u = new User();
//		u.setName("1234");
//		u.setPassword("1234");
//		iu.checkUser(u);
//		MessageDigest mdInst = MessageDigest.getInstance("MD5");
//
//		System.out.println(Hex.encodeHex(mdInst.digest("1234".getBytes())));
		
		Room room = new Room();
		Random r =new Random();
		for(int i=1;i<=10;i++){
			room.setRoom_id(100+i);
			int n = r.nextInt(3);
			room.setType(n);
			room.setMoney(n*100);
			room.setPicture("/images/"+i);
			rd.insertRoom(room);
		}
	}
}

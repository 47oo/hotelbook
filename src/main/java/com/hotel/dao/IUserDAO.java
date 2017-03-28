package com.hotel.dao;

import java.util.List;

import com.hotel.domain.User;

public interface IUserDAO {
	
	public List<Integer> getId();
	//新增用户,只能单条插入
	int insertUser(User u);
	
	int hasUser(User u);
}

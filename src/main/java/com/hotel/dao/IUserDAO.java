package com.hotel.dao;

import java.util.List;

import com.hotel.domain.User;

public interface IUserDAO {
	
	public List<Integer> getId();
	//新增用户,只能单条插入
	int insertUser(User u);
	//判断用户账户密码是否正确
	int hasUser(User u);
}

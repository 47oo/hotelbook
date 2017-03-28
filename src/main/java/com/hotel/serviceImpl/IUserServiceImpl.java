package com.hotel.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.dao.IUserDAO;
import com.hotel.domain.User;
import com.hotel.service.IUserService;
import com.hotel.vo.ResponseJson;
/**
 * 
 * @author 47 
 *
 */
@Service
public class IUserServiceImpl implements IUserService{
	@Autowired
	private IUserDAO userDAO;
	/**
	 * 用户判断用户是否注册成功
	 */
	@Override
	public ResponseJson register(User u) {
		ResponseJson rj = new ResponseJson();
		if(userDAO.insertUser(u)==1){
			rj.setCode("1");
		}else{
			rj.setCode("0");
		}
		return rj;
	}
	/**
	 * 判断用户是否可以登录
	 */
	@Override
	public ResponseJson login(User u) {
		ResponseJson rj = new ResponseJson();
		if(userDAO.hasUser(u)==1){
			rj.setCode("1");
		}else{
			rj.setCode("0");
		}
		return rj;
	}
}

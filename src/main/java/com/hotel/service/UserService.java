package com.hotel.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hotel.model.User;
import com.hotel.response.UserDO;

/**
 * @author hp
 * @version 1.0
 */
public interface UserService {

	/**
	 * 
	 * @param user
	 */
	public UserDO checkUser(HttpServletRequest request,User user);

	public void deleteUser();

	public List<User> getUserByIdCard();

	public List<User> getUserByUsername();

	public List<User> listUsertoAdmin();

	/**
	 * 
	 * @param user
	 */
	public void updateUser(User user);

	public UserDO getUserInfo(HttpServletRequest request);

}
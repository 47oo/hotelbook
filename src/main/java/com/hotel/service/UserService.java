package com.hotel.service;

import java.util.List;

import com.hotel.model.User;

/**
 * @author hp
 * @version 1.0
 */
public interface UserService {

	/**
	 * 
	 * @param user
	 */
	public abstract boolean checkUser(User user);

	public void deleteUser();

	public List<User> getUserByIdCard();

	public List<User> getUserByUsername();

	public List<User> listUsertoAdmin();

	/**
	 * 
	 * @param user
	 */
	public void updateUser(User user);

}
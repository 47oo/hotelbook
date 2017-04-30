package com.hotel.dao;

import java.util.List;

import com.hotel.model.User;

/**
 * @author hp
 * @version 1.0
 */
public interface UserDAO {

	/**
	 * 
	 * @param user
	 */
	public List<User> checkUser(User user);

	/**
	 * 
	 * @param id
	 */
	public void deleteById(int id);

	/**
	 * 
	 * @param user
	 */
	public void insertUser(User user);

	public List<User> listToAdmin();

	/**
	 * 
	 * @param user
	 */
	public void updateUser(User user);

}
package com.hotel.dao;

import java.util.List;

import com.hotel.model.Order;
import com.hotel.model.User;

/**
 * @author hp
 * @version 1.0
 */
public interface OrderDAO {

	/**
	 * 
	 * @param order
	 */
	public void insertOrder(Order order);

	/**
	 * 
	 * @param start
	 * @param size
	 */
	public List<Order> listToAdmin(int start, int size);

	/**
	 * 
	 * @param user
	 * @param start
	 * @param size
	 */
	public List<Order> listToUser(User user, int start, int size);

}
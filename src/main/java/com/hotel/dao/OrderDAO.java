package com.hotel.dao;

import java.util.List;

import com.hotel.model.Order;
import com.hotel.model.User;
import org.apache.ibatis.annotations.Param;

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
	public List<Order> listToAdmin(@Param("start") int start, @Param("size") int size);

	/**
	 * 
	 * @param user
	 * @param start
	 * @param size
	 */
	public List<Order> listToUser(@Param("username") String username, @Param("start") int start, @Param("size") int size);

}
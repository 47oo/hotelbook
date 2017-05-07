package com.hotel.service;

import java.util.List;

import com.hotel.model.Order;
import com.hotel.request.OrderQueryRequest;
import com.hotel.response.CommonDO;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hp
 * @version 1.0
 * @created 30-4��-2017 20:44:10
 */
public interface OrderService {

	/**
	 * 
	 * @param start
	 * @param size
	 */
	public List<Order> listToAdmin(int start, int size);

	public CommonDO listToUser(OrderQueryRequest orderQueryRequest, HttpServletRequest request);

}
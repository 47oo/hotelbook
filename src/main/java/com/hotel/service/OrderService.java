package com.hotel.service;

import java.util.List;

import com.hotel.model.Order;
import com.hotel.request.OrderQueryRequest;
import com.hotel.response.CommonDO;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hp
 * @version 1.0

 */
public interface OrderService {


	 CommonDO listToAdmin(OrderQueryRequest orderQueryRequest);

	 CommonDO listToUser(OrderQueryRequest orderQueryRequest, HttpServletRequest request);

}
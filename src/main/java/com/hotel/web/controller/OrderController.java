package com.hotel.web.controller;


import com.hotel.request.OrderQueryRequest;
import com.hotel.request.Request;
import com.hotel.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hp
 * @version 1.0
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/orderlist")
    @ResponseBody
    public Object listOrderToUser(OrderQueryRequest orderQueryRequest, HttpServletRequest request) {

       return  orderService.listToUser(orderQueryRequest,request);
    }
    @RequestMapping("/list")
    @ResponseBody
    public Object list(OrderQueryRequest orderQueryRequest){

        return orderService.listToAdmin(orderQueryRequest);
    }

}
package com.hotel.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotel.common.constant.Constant;
import com.hotel.model.User;
import com.hotel.service.UserService;

/**
 * @author hp
 * @version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("/login.action")
	@ResponseBody
	public Object login(HttpServletRequest request,User user){
		return userService.checkUser(request,user);
	}
	@RequestMapping("/personal.action")
	@ResponseBody
	public Object userInfo(HttpServletRequest request){
		
		return userService.getUserInfo(request);
	}

}
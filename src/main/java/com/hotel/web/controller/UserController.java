package com.hotel.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotel.domain.User;
import com.hotel.service.IUserService;
import com.hotel.vo.ResponseJson;

@Controller
public class UserController {
	@Autowired
	private IUserService is;
	@RequestMapping(value="/register.action",method = RequestMethod.POST)
	@ResponseBody
	public ResponseJson resgister(User user){
		return is.register(user);
	}
	@RequestMapping(value="/login.action",method = RequestMethod.POST)
	@ResponseBody
	public ResponseJson login(User user){
		return is.login(user);
	}
}

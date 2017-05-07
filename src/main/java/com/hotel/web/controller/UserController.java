package com.hotel.web.controller;

import javax.servlet.http.HttpServletRequest;

import com.hotel.common.constant.Constant;
import com.hotel.request.RoomQueryRequest;
import com.hotel.response.CommonDO;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotel.model.User;
import com.hotel.request.Request;
import com.hotel.service.RoomService;
import com.hotel.service.UserService;

/**
 * @author hp
 * @version 1.0
 */
@Controller
@RequestMapping("/user")
@Log4j
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired 
	RoomService roomService;
	
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
	
	@RequestMapping(value ="/roomlist.action")
	@ResponseBody
	public Object listEmptyRoom(Request request){
		
		return roomService.emptyRoom(request);
	}

	@RequestMapping(value ="/bookroom.action")
	@ResponseBody
	public Object bookRoom(RoomQueryRequest roomQueryRequest,HttpServletRequest request){
		CommonDO co = null;
		try{
			co = roomService.bookRoom(roomQueryRequest,request);
		}catch(Exception e){
			co = new CommonDO();
			co.setCode(Constant.Room.WRONG_CODE);
			log.debug(e);
		}
		return co;
	}

}
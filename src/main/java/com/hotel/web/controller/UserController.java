package com.hotel.web.controller;

import javax.servlet.http.HttpServletRequest;

import com.hotel.request.UserRequest;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotel.model.User;
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

    @RequestMapping("/login.action")
    @ResponseBody
    public Object login(HttpServletRequest request, User user) {
        return userService.checkUser(request, user);
    }

    @RequestMapping("/personal.action")
    @ResponseBody
    public Object userInfo(HttpServletRequest request) {

        return userService.getUserInfo(request);
    }


    @RequestMapping(value = "/register.action")
    @ResponseBody
    public Object register(User user) {
        return userService.register(user);
    }

    @RequestMapping(value = "/changepwd.action")
    @ResponseBody
    public Object changePwd(UserRequest userRequest,HttpServletRequest request){
        return userService.updateUserPwd(userRequest,request);
    }
}
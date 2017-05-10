package com.hotel.web.controller;


import com.hotel.model.Admin;
import com.hotel.request.AdminRequest;
import com.hotel.service.AdminService;
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
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/login.action")
    @ResponseBody
    public Object login(HttpServletRequest request, Admin admin) {
        return adminService.checkAdmin(request, admin);
    }
    @RequestMapping("/changepwd.action")
    @ResponseBody
    public Object changePwd(HttpServletRequest request, AdminRequest adminRequest){
        return adminService.updatePwd(request,adminRequest);
    }

}
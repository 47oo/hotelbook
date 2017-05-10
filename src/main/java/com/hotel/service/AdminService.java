package com.hotel.service;

import com.hotel.model.Admin;
import com.hotel.request.AdminRequest;
import com.hotel.response.AdminDO;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hp
 * @version 1.0
 */
public interface AdminService {

    /**
     * @param admin
     */
    AdminDO checkAdmin(HttpServletRequest request, Admin admin);

    AdminDO updatePwd(HttpServletRequest request, AdminRequest adminRequest);
}
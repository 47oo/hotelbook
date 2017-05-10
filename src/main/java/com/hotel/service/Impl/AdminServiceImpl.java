package com.hotel.service.Impl;

import com.hotel.common.constant.Constant;
import com.hotel.dao.AdminDAO;
import com.hotel.model.Admin;
import com.hotel.request.AdminRequest;
import com.hotel.response.AdminDO;
import com.hotel.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by hp on 2017/5/8.
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDAO adminDAO;
    @Override
    public AdminDO checkAdmin(HttpServletRequest request, Admin admin) {
        List<Admin> list = adminDAO.checkAdmin(admin);
        AdminDO adminDO = new AdminDO();
        if(list.size()!=1){
            adminDO.setCode(Constant.Admin.WRONG_CODE);
        }else{
            request.getSession().setAttribute("admin",list.get(0));
        }
        return adminDO;
    }

    @Override
    public AdminDO updatePwd(HttpServletRequest request, AdminRequest adminRequest) {
        String oldpwd = adminRequest.getOldpwd();
        String newpwd = adminRequest.getNewpwd();
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        AdminDO adminDO = new AdminDO();
        boolean flag = adminDAO.updatePwd(oldpwd,newpwd,admin.getUsername())==1;
        if(!flag){
            adminDO.setCode(Constant.Admin.WRONG_CODE);
        }
        return adminDO;
    }

}

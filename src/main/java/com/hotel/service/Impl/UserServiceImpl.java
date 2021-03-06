package com.hotel.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.hotel.common.CommonUtils;
import com.hotel.common.MD5Utils;
import com.hotel.request.UserQueryRequest;
import com.hotel.request.UserRequest;
import com.hotel.response.CommonDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.common.constant.Constant;
import com.hotel.dao.UserDAO;
import com.hotel.model.User;
import com.hotel.response.UserDO;
import com.hotel.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDO checkUser(HttpServletRequest request, User user) {
        //此处使用MD5加密验证登录
        user.setPassword(MD5Utils.passwordToMD5(user.getPassword()));
        List<User> list = userDAO.checkUser(user);
        UserDO ud = new UserDO();
        if (list.size() != 1) {
            ud.setCode(Constant.User.WRONG_CODE);
        } else {
            request.getSession().setAttribute("user", list.get(0));
        }
        return ud;
    }

    @Override
    public UserDO deleteUser(String username) {
        UserDO u= new UserDO();

        if(userDAO.deleteByUsername(username)!=1)
            u.setCode(Constant.User.WRONG_CODE);
        return u;
    }


    @Override
    public List<User> getUserByIdCard() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<User> getUserByUsername() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CommonDO listUsertoAdmin(UserQueryRequest userQueryRequest) {
        List<User> list = userDAO.listToAdmin(CommonUtils.start(userQueryRequest),userQueryRequest.getSize());
        List<UserDO> dolist = new ArrayList<>();
        UserDO udo =null;
        for(User u:list){
            udo = new UserDO();
            userToUserDO(u,udo);
            dolist.add(udo);
        }
        CommonDO commonDO = new CommonDO();
        commonDO.setData(dolist);
        return commonDO;
    }


    @Override
    public UserDO updateUser(UserRequest user, HttpServletRequest request) {
        return null;
    }

    @Override
    public UserDO updateUserPwd(UserRequest user,HttpServletRequest request) {
        UserDO userDO = new UserDO();
        User u = (User) request.getSession().getAttribute("user");
        //数据库存储的加密后的密码，这里需要将密码加密后再做校验
        String oldpwd = MD5Utils.passwordToMD5(user.getOldpwd());
        String newpwd = MD5Utils.passwordToMD5(user.getNewpwd());
        boolean flag = userDAO.updateUserPwd(oldpwd,newpwd,u.getUsername())==1;
        if(!flag){
            userDO.setCode(Constant.User.WRONG_CODE);
        }
        return userDO;
    }

    @Override
    public UserDO getUserInfo(HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserDO ud = new UserDO();
        User u = (User) session.getAttribute("user");
        if (u == null) {
            ud.setCode(Constant.User.WRONG_CODE);
        }
        userToUserDO(u, ud);
        return ud;
    }

    @Override
    public UserDO register(User user) {
        UserDO userDO = new UserDO();
        try{
            user.setPassword(MD5Utils.passwordToMD5(user.getPassword()));
            userDAO.insertUser(user);
        }catch (Exception e){
            userDO.setCode(Constant.User.WRONG_CODE);
        }
        return userDO;
    }

    private void userToUserDO(User u, UserDO ud) {
        ud.setIdcard(u.getIdcard());
        ud.setEmail(u.getEmail());
        ud.setName(u.getName());
        ud.setPhone(u.getPhone());
        ud.setUsername(u.getUsername());
    }

}

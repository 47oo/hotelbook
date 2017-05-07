package com.hotel.service.Impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.hotel.common.MD5Utils;
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
    public void deleteUser() {
        // TODO Auto-generated method stub

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
    public List<User> listUsertoAdmin() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateUser(User user) {
        // TODO Auto-generated method stub

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
        ud.setEmail(u.getEmail());
        ud.setName(u.getName());
        ud.setPhone(u.getPhone());
    }

}

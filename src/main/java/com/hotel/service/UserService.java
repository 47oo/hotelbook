package com.hotel.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hotel.model.User;
import com.hotel.request.UserRequest;
import com.hotel.response.UserDO;

/**
 * @author hp
 * @version 1.0
 */
public interface UserService {

    /**
     * @param user
     */
    UserDO checkUser(HttpServletRequest request, User user);

    void deleteUser();

    List<User> getUserByIdCard();

    List<User> getUserByUsername();

    List<User> listUsertoAdmin();

    /**
     * @param user
     */
    UserDO updateUser(UserRequest user,HttpServletRequest request);

    UserDO getUserInfo(HttpServletRequest request);

    UserDO updateUserPwd(UserRequest user,HttpServletRequest request);
    UserDO register(User user);
}
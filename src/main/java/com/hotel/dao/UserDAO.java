package com.hotel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hotel.model.User;

/**
 * @author hp
 * @version 1.0
 */
public interface UserDAO {

    /**
     * @param user
     */
    public List<User> checkUser(User user);

    /**
     * @param username
     */
    int deleteByUsername(@Param("username") String username);

    /**
     * @param user
     */
    public void insertUser(User user);

    public List<User> listToAdmin(@Param("start") int start, @Param("size") int size);

    /**
     * @param user
     */
    public void updateUser(User user);

    public int updateUserPwd(@Param("oldpwd") String oldpwd, @Param("newpwd") String newpwd, @Param("username") String username);

}
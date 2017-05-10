package com.hotel.dao;

import java.util.List;

import com.hotel.model.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * @author hp
 * @version 1.0
 */
public interface AdminDAO {

	/**
	 * 
	 * @param admin
	 */
	 List<Admin> checkAdmin(Admin admin);

    int updatePwd(@Param("oldpwd") String oldpwd, @Param("newpwd") String newpwd, @Param("username") String username);
}
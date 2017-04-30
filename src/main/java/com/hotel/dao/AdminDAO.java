package com.hotel.dao;

import java.util.List;

import com.hotel.model.Admin;

/**
 * @author hp
 * @version 1.0
 */
public interface AdminDAO {

	/**
	 * 
	 * @param admin
	 */
	public abstract List<Admin> checkAdmin(Admin admin);

}
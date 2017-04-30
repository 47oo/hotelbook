package com.hotel.dao;

import java.util.List;

import com.hotel.model.Room;

/**
 * @author hp
 * @version 1.0
 * @created 30-4��-2017 20:48:02
 */
public interface RoomDAO {

	/**
	 * 
	 * @param room
	 */
	public void deleteRoom(Room room);

	/**
	 * 
	 * @param room
	 */
	public void insertRoom(Room room);

	public List<Room> list();

	public List<Room> listEmptyRoom();

	/**
	 * 
	 * @param username
	 */
	public int listRoomByUser(String username);

	/**
	 * 
	 * @param room
	 */
	public void updateRoom(Room room);

}
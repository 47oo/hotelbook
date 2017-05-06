package com.hotel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hotel.model.Room;

/**
 * @author hp
 * @version 1.0
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

	public List<Room> list(@Param("start")int start,@Param("size") int size);

	public List<Room> listEmptyRoom(@Param("start")int start,@Param("size") int size);

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
package com.hotel.service;

import com.hotel.model.Room;

/**
 * @author hp
 * @version 1.0
 */
public interface RoomService {

	/**
	 * 
	 * @param room
	 */
	public void addRoom(Room room);

	/**
	 * 
	 * @param room
	 */
	public void deleteRoom(Room room);

	/**
	 * 
	 * @param room
	 */
	public void updateRoomStatus(Room room);

}
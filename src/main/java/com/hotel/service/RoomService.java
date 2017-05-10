package com.hotel.service;

import com.hotel.model.Room;
import com.hotel.request.Request;
import com.hotel.request.RoomQueryRequest;
import com.hotel.response.CommonDO;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hp
 * @version 1.0
 */
public interface RoomService {

    /**
     * @param room
     */
    void addRoom(Room room);

    /**
     * @param room
     */
    void deleteRoom(Room room);

    /**
     * @param room
     */
    void updateRoomStatus(Room room);

    CommonDO emptyRoom(Request request);

    CommonDO bookRoom(RoomQueryRequest roomQueryRequest, HttpServletRequest request);

    CommonDO list(Request request);
}
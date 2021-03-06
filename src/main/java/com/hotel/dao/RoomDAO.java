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
     * @param room
     */
    void deleteRoom(Room room);

    /**
     * @param room
     */
    void insertRoom(Room room);

    List<Room> list(@Param("start") int start, @Param("size") int size);

    List<Room> listByStatus(@Param("status") int status,@Param("start") int start, @Param("size") int size);

    /**
     * @param username
     */
    int listRoomByUser(String username);

    /**
     * @param room
     */
    void updateRoom(Room room);

    void updateRoomStatus(@Param("status") int status, @Param("idcard")String idcard,@Param("username") String username,@Param("room_id") int room_id);

    List<Room> roomStatus(@Param("room_id") int room_id);

    void updateRoomImage(@Param("room_id") Integer roomId, @Param("image") String imagePath);

    void add(Room room);
}
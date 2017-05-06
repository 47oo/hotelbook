package com.hotel.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.dao.RoomDAO;
import com.hotel.model.Room;
import com.hotel.request.Request;
import com.hotel.response.CommonDO;
import com.hotel.response.RoomDO;
import com.hotel.service.RoomService;
@Transactional
@Service
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	private RoomDAO roomDAO;
	@Override
	public void addRoom(Room room) {

	}

	@Override
	public void deleteRoom(Room room) {

	}

	@Override
	public void updateRoomStatus(Room room) {
		roomDAO.updateRoom(room);
	}

	@Override
	public CommonDO emptyRoom(Request request) {
		List<Room> list = roomDAO.listEmptyRoom((request.getStart() - 1) * request.getSize(), request.getSize());
		CommonDO cd = new CommonDO();
		List<RoomDO> dolist = new ArrayList<>();
		RoomDO rd = null;
		for (Room room : list) {
			rd = new RoomDO();
			rd.setMoney(room.getMoney());
			rd.setType(room.getType());
			rd.setRoom_id(room.getRoom_id());
			dolist.add(rd);
		}
		cd.setData(dolist);
		return cd;
	}

}

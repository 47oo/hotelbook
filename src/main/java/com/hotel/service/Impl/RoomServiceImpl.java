package com.hotel.service.Impl;

import java.util.ArrayList;
import java.util.List;

import com.hotel.common.CommonUtils;
import com.hotel.common.TimeUtils;
import com.hotel.common.constant.Constant;
import com.hotel.dao.OrderDAO;
import com.hotel.exception.TimeNullException;
import com.hotel.model.Order;
import com.hotel.model.User;
import com.hotel.request.RoomQueryRequest;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.dao.RoomDAO;
import com.hotel.model.Room;
import com.hotel.request.Request;
import com.hotel.response.CommonDO;
import com.hotel.response.RoomDO;
import com.hotel.service.RoomService;

import javax.servlet.http.HttpServletRequest;

@Transactional
@Service
@Log4j
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	private RoomDAO roomDAO;
	@Autowired
	private OrderDAO orderDAO;
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

	@Override
	public synchronized CommonDO bookRoom(RoomQueryRequest roomQueryRequest, HttpServletRequest request) {
		CommonDO commonDO = new CommonDO();
		User u = (User)request.getSession().getAttribute("user");
		Room room = roomDAO.roomStatus(roomQueryRequest.getRoom_id()).get(0);
		if(room.getStatus()==Constant.Room.UNBOOK){
			roomDAO.updateRoomStatus(Constant.Room.BOOKING,u.getUsername(),roomQueryRequest.getRoom_id());
			Order order = new Order();
			order.setOrder_id(CommonUtils.randomOrderId(u.getIdcard()));
			order.setCtime(TimeUtils.now());
			order.setMoney(room.getMoney());
			order.setRoom_id(room.getRoom_id());
			order.setUsername(u.getUsername());
			long citime = judgeTime(roomQueryRequest.getCitime());
			order.setCtime(citime);
			long cotime = judgeTime(roomQueryRequest.getCotime());
			order.setCotime(cotime);
			orderDAO.insertOrder(order);
		}else{
			commonDO.setCode(Constant.Room.WRONG_CODE);
		}
		return commonDO;
	}

	private long judgeTime(String time) {
		Long sp =TimeUtils.getTimeStamp(time,"yyyy-MM-dd");
		if(sp==null){
			log.debug(time+" is wrong");
			throw new TimeNullException();
		}
		return sp;
	}


}

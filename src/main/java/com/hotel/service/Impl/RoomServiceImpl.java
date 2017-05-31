package com.hotel.service.Impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.hotel.common.CommonUtils;
import com.hotel.common.TimeUtils;
import com.hotel.common.constant.Constant;
import com.hotel.convertor.RoomDOConvertor;
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
import org.springframework.web.multipart.commons.CommonsMultipartFile;

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
    public CommonDO addRoom(CommonsMultipartFile file, Room room) {
        CommonDO commonDO = new CommonDO();
        if(room.getRoom_id()==null) {
            commonDO.setCode(Constant.Room.WRONG_CODE);
            return commonDO;
        }
        String imagePath = getRoomImageSavePath() + "/" + room.getRoom_id() + ".jpg";
        try {
            upload(new File(imagePath),file);
            room.setPicture(imagePath);
            roomDAO.add(room);
        } catch (Exception e) {
            log.error("upload image error");
            commonDO.setCode(Constant.Room.WRONG_CODE);
        }
        return commonDO;
    }

    @Override
    public void deleteRoom(Room room) {

    }

    @Override
    public CommonDO updateRoomStatus(Room room) {
        // 这个地方不做判断我是懒得，你觉得怎么样
        CommonDO commonDO = new CommonDO();
        roomDAO.updateRoom(room);
        return commonDO;
    }

    @Override
    public CommonDO emptyRoom(Request request) {
        List<Room> list = roomDAO.listByStatus(Constant.Room.UNBOOK, (request.getStart() - 1) * request.getSize(), request.getSize());
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
        User u = (User) request.getSession().getAttribute("user");
        Room room = roomDAO.roomStatus(roomQueryRequest.getRoom_id()).get(0);
        if (room.getStatus() == Constant.Room.UNBOOK) {
            roomDAO.updateRoomStatus(Constant.Room.BOOKING, u.getIdcard(), u.getUsername(), roomQueryRequest.getRoom_id());
            Order order = new Order();
            order.setOrder_id(CommonUtils.randomOrderId(u.getIdcard()));
            order.setCtime(TimeUtils.now());
            long citime = judgeTime(roomQueryRequest.getCitime());
            order.setCitime(citime);
            long cotime = judgeTime(roomQueryRequest.getCotime());
            order.setCotime(cotime);
            order.setMoney(room.getMoney() * TimeUtils.days(citime, cotime));
            order.setRoom_id(room.getRoom_id());
            order.setUsername(u.getUsername());
            orderDAO.insertOrder(order);
        } else {
            commonDO.setCode(Constant.Room.WRONG_CODE);
        }
        return commonDO;
    }

    @Override
    public CommonDO list(Request request) {
        List<Room> list = roomDAO.list((request.getStart() - 1) * request.getSize(), request.getSize());
        CommonDO cd = new CommonDO();
        List<RoomDO> dolist = RoomDOConvertor.toDO(list);
        cd.setData(dolist);
        return cd;
    }

    @Override
    public CommonDO uploadImage(CommonsMultipartFile file, Integer roomId) {
        CommonDO commonDO = new CommonDO();
        if(roomId==null){
            commonDO.setCode(Constant.Room.WRONG_CODE);
            return commonDO;
        }
        String imagePath = getRoomImageSavePath() + "/" + roomId + ".jpg";
        File image = new File(imagePath);
        try {
            upload(image,file);
            roomDAO.updateRoomImage(roomId, imagePath);
            log.info("upload image success");
        } catch (Exception e) {
            log.debug("file upload failure");
            commonDO.setCode(Constant.Room.WRONG_CODE);
        }
        return commonDO;
    }
    private void upload(File image,CommonsMultipartFile file) throws IOException {
        if(file.isEmpty()) throw new RuntimeException("no upload file");
        if(image.exists()){
            image.delete();
        }
        file.transferTo(image);
    }
    private long judgeTime(String time) {
        Long sp = TimeUtils.getTimeStamp(time, "yyyy-MM-dd");
        if (sp == null) {
            log.debug(time + " is wrong");
            throw new TimeNullException();
        }
        return sp;
    }

    private static String getRoomImageSavePath() {
        String str = RoomService.class.getClassLoader().getResource("").getPath();
        File f = new File(str);
        str = f.getParentFile().getParent()+"/room-image";
        log.info(str);
        return str;
    }


}

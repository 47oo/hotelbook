package com.hotel.convertor;

import com.hotel.common.constant.Constant;
import com.hotel.model.Room;
import com.hotel.response.RoomDO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 2017/5/21.
 */
public class RoomDOConvertor {
    public static List<RoomDO> toDO(List<Room> list){
        List<RoomDO> dolist = new ArrayList<>();
        RoomDO rd = null;
        for (Room room : list) {
            rd = new RoomDO();
            rd.setMoney(room.getMoney());
            rd.setType(room.getType());
            rd.setRoom_id(room.getRoom_id());
            if(room.getStatus()== Constant.Room.UNBOOK){
                rd.setIdcard("");
            }else{
                rd.setIdcard(room.getIdcard());
            }
           if(room.getStatus()==Constant.Room.UNBOOK){
                rd.setStatus("未预订");
                rd.setIdcard("");
           }else if(room.getStatus()==Constant.Room.BOOKING){
               rd.setStatus("已预订");
           }else if(room.getStatus()==Constant.Room.BOOKED){
               rd.setStatus("入住中");
           }
            dolist.add(rd);
        }
        return dolist;
    }
}

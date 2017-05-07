package com.hotel.web.controller;


import com.hotel.common.constant.Constant;
import com.hotel.request.Request;
import com.hotel.request.RoomQueryRequest;
import com.hotel.response.CommonDO;
import com.hotel.service.RoomService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hp
 * @version 1.0
 */
@Controller
@Log4j
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @RequestMapping(value = "/bookroom.action")
    @ResponseBody
    public Object book(RoomQueryRequest roomQueryRequest, HttpServletRequest request) {
        CommonDO co = null;
        try {
            co = roomService.bookRoom(roomQueryRequest, request);
        } catch (Exception e) {
            co = new CommonDO();
            co.setCode(Constant.Room.WRONG_CODE);
            log.debug(e);
        }
        return co;
    }

    @RequestMapping(value = "/roomlist.action")
    @ResponseBody
    public Object listEmptyRoom(Request request) {
        return roomService.emptyRoom(request);
    }
}
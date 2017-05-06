package com.hotel.response;

import com.hotel.common.constant.Constant;

public class RoomDO {
	
	private int room_id;
	private String type;
	private double money;
	public int getRoom_id() {
		return room_id;
	}
	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}
	public String getType() {
		return type;
	}
	public void setType(int type) {
		if(type==Constant.Room.BIG_ROOM){
			this.type = "大床房";
		}else if(type==Constant.Room.MID_ROOM){
			this.type = "中床房";
		}else {
			this.type = "小床房";
		}
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}	
}

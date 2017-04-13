package com.hotel.domain;

import java.util.Date;

public class Room {
	//酒店房间编号
	private String room_id;
	//酒店房间类型
	private String type_id;
	//酒店房间介绍
	private String room_recommend;
	//酒店房间照片
	private String room_photo;
	//此房间预定时间
	private Date preset_time;
	//预定结束时间
	private Date end_time;
	//预定者
	private String idcard; //如果 idcard = 0则表示没有人预定
	public String getRoom_id() {
		return room_id;
	}
	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}
	public String getType_id() {
		return type_id;
	}
	public void setType_id(String type_id) {
		this.type_id = type_id;
	}
	public String getRoom_recommend() {
		return room_recommend;
	}
	public void setRoom_recommend(String room_recommend) {
		this.room_recommend = room_recommend;
	}
	public String getRoom_photo() {
		return room_photo;
	}
	public void setRoom_photo(String room_photo) {
		this.room_photo = room_photo;
	}
	public Date getPreset_time() {
		return preset_time;
	}
	public void setPreset_time(Date preset_time) {
		this.preset_time = preset_time;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
}

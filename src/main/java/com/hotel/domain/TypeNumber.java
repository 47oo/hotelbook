package com.hotel.domain;
/**
 * 各个类型房间总数,及剩余数量
 * @author 
 *
 */
public class TypeNumber {
	//房间类型id
	private String type_id;
	//房间类型名称
	private String type;
	//此类房间总数
	private int room_sum;
	//此类房间剩余数量
	private int room_remain;
	//此类房间价格
	private int money;
	public String getType_id() {
		return type_id;
	}
	public void setType_id(String type_id) {
		this.type_id = type_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getRoom_sum() {
		return room_sum;
	}
	public void setRoom_sum(int room_sum) {
		this.room_sum = room_sum;
	}
	public int getRoom_remain() {
		return room_remain;
	}
	public void setRoom_remain(int room_remain) {
		this.room_remain = room_remain;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
}

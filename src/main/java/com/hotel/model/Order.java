package com.hotel.model;


/**
 * @author hp
 * @version 1.0
 * @tabel order_d
 */
public class Order {

	private long citime;
	private long cotime;
	private long ctime;
	private int id;
	private double money;
	private String order_id;
	private int room_id;
	private String username;

	public Order(){

	}

	public long getCitime() {
		return citime;
	}

	public void setCitime(long citime) {
		this.citime = citime;
	}

	public long getCotime() {
		return cotime;
	}

	public void setCotime(long cotime) {
		this.cotime = cotime;
	}

	public long getCtime() {
		return ctime;
	}

	public void setCtime(long ctime) {
		this.ctime = ctime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
}
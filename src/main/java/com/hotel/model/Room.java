package com.hotel.model;


/**
 * @author hp
 * @version 1.0
 * @table room
 */
public class Room {

	private int id;
	private double money;
	private String picture;
	private int romm_id;
	private int status;
	private String username;

	public Room(){

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

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getRomm_id() {
		return romm_id;
	}

	public void setRomm_id(int romm_id) {
		this.romm_id = romm_id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
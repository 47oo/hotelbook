package com.hotel.model;


import lombok.Data;

/**
 * @author hp
 * @version 1.0
 * @tabel order_d
 */
@Data
public class Order {

	private long citime;
	private long cotime;
	private long ctime;
	private int id;
	private double money;
	private String order_id;
	private int room_id;
	private String username;

	
}
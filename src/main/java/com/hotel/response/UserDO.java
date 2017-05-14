package com.hotel.response;

import lombok.Data;

@Data
public class UserDO {

	private int code = 1;
	private String name;
	private String email;
	private String phone;
	private String username;

	private String idcard;
}

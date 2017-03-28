package com.hotel.service;

import com.hotel.domain.User;
import com.hotel.vo.ResponseJson;

public interface IUserService {
	ResponseJson register(User u);
	ResponseJson login(User u);
}

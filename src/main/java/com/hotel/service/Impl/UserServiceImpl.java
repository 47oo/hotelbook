package com.hotel.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.common.constant.Constant;
import com.hotel.dao.RoomDAO;
import com.hotel.dao.UserDAO;
import com.hotel.model.Room;
import com.hotel.model.User;
import com.hotel.request.Request;
import com.hotel.response.CommonDO;
import com.hotel.response.RoomDO;
import com.hotel.response.UserDO;
import com.hotel.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private RoomDAO roomDAO;

	@Override
	public UserDO checkUser(HttpServletRequest request, User user) {
		List<User> list = userDAO.checkUser(user);
		UserDO ud = new UserDO();
		if (list.size() != 1) {
			ud.setCode(Constant.User.WRONG_CODE);
		} else {
			request.getSession().setAttribute("user", list.get(0));
		}
		return ud;
	}

	@Override
	public void deleteUser() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> getUserByIdCard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUserByUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> listUsertoAdmin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public UserDO getUserInfo(HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserDO ud = new UserDO();
		User u = (User) session.getAttribute("user");
		if (u == null) {
			ud.setCode(Constant.User.WRONG_CODE);
		}
		userToUserDO(u, ud);
		return ud;
	}

	private void userToUserDO(User u, UserDO ud) {
		ud.setEmail(u.getEmail());
		ud.setName(u.getName());
		ud.setPhone(u.getPhone());
	}

	@Override
	public Object emptyRoom(Request request) {

		List<Room> list = roomDAO.listEmptyRoom((request.getStart() - 1) * request.getSize(), request.getSize());
		CommonDO cd = new CommonDO();
		List<RoomDO> dolist = new ArrayList<>();
		RoomDO rd = null;
		for (Room room : list) {
			rd = new RoomDO();
			rd.setMoney(room.getMoney());
			rd.setType(room.getType());
			rd.setRoom_id(room.getRomm_id());
			dolist.add(rd);
		}
		cd.setData(dolist);
		return cd;
	}
}

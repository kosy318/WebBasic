package com.mvc.model.service;

import com.mvc.model.dao.UserDAO;
import com.mvc.model.dao.UserDAOImpl;
import com.mvc.model.vo.User;

public class UserServiceImpl implements UserService {
	UserDAO dao;
	
	public UserServiceImpl() {
		dao = new UserDAOImpl();
	}
	
	@Override
	public boolean check(User user) {		
		return dao.check(user);
	}

}

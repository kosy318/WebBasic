package com.mvc.model.service;

import com.mvc.model.dao.UserDAO;
import com.mvc.model.dao.UserDAOImpl;
import com.mvc.model.vo.User;

// BoardService 인터페이스 안의 메소드를 구현한 객체
// Controller에게서 들어온 요청을 처리하는 객체
// DAO에게 요청을 넘김
public class UserServiceImpl implements UserService{
	UserDAO dao; // Interface type

	public UserServiceImpl() {
		dao = new UserDAOImpl();
	}

	@Override
	public boolean check(User user) {
		return dao.check(user);
	}

}

package com.mvc.model.dao;


import com.mvc.model.vo.User;

// Controller를 위한 인터페이스
public interface UserDAO {
	boolean check(User user);
}

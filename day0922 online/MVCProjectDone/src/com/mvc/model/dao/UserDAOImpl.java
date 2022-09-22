package com.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mvc.model.vo.User;
import com.mvc.util.DBUtil;
//BoardDAO의 메소드를 구현한 객체.
//Service에서 들어온 요청을 최종적으로 처리하는 객체
//DB 작업 수행(CRUD)
public class UserDAOImpl implements UserDAO{
	private DBUtil util;

	public UserDAOImpl() {// 만들어진 connection pool 찾아오기
		util = DBUtil.getInstance();
	}

	@Override
	public boolean check(User u) {
		boolean flag = false;
	
		String q = "select id, pass from user where id = ? and pass=?";		
		try {
			Connection con = util.getConnection();
			PreparedStatement stat = con.prepareStatement(q);
			stat.setString(1, u.getId());
			stat.setString(2, u.getPass());
			
			ResultSet rs = stat.executeQuery();
			if(rs.next()) flag = true;				
			util.close(rs, stat, con);			
		} catch (Exception e) {
			e.printStackTrace();
		}				
		return flag;
	}
}








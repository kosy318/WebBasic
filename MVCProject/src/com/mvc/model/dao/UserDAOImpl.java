package com.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mvc.model.vo.User;
import com.mvc.util.DBUtil;

// BoardDAO 인터페이스 안의 메소드를 구현한 객체
// Service객체에게서 들어온 요청을 처리
// DB작업을 수행(CRUD)
public class UserDAOImpl implements UserDAO {
	DBUtil util; // connection 열기..
	
	public UserDAOImpl() {
		util = DBUtil.getInstance();
	}

	@Override
	public boolean check(User user) {
		String q = "select pass from user where id=?";
		
		try {
			Connection con = util.getConnection();
			PreparedStatement stat = con.prepareStatement(q);
			stat.setString(1, user.getId());
			
			ResultSet rs = stat.executeQuery();
			if(rs.next()){
				String pass = rs.getString(1);
				
				if(pass.equals(user.getPass())) return true;
			}
			util.close(rs, stat, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}

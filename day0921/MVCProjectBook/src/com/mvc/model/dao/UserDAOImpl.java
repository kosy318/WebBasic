package com.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import com.mvc.model.vo.User;
import com.mvc.util.DBUtil;

public class UserDAOImpl implements UserDAO {

	DBUtil util;
	
	public UserDAOImpl() {
		util = DBUtil.getInstance();
	}
	
	@Override
	public boolean check(User user) {
		String sql = "select pass from user where id=?";
		try {
			Connection con = util.getConnection();
			PreparedStatement stat = con.prepareStatement(sql);
			stat.setString(1, user.getPass());
			ResultSet rs = stat.executeQuery();
			
			if(rs.next()) {
				String pass = rs.getString(1);
				
				if(pass.equals(user.getPass()))
					return true;
			}
			util.close(stat, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}

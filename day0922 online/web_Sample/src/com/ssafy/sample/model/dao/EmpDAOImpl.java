package com.ssafy.sample.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ssafy.sample.dto.Emp;
import com.ssafy.sample.util.DBUtil;

public class EmpDAOImpl implements EmpDAO {
	
	DBUtil util;
	
	public EmpDAOImpl() {
		util = DBUtil.getInstance();
	}

	@Override
	public ArrayList<Emp> selectAll() {
		String sql = "select empid, fname, deptid from myemp order by empid desc";
		ArrayList<Emp> list = new ArrayList<>();
		
		try {
			Connection con = util.getConnection();
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				String empid = rs.getString(1);
				String fname = rs.getString(2);
				String deptid = rs.getString(3);
				
				Emp e = new Emp(empid, fname, null, null, null, deptid);
				list.add(e);
			}
			
			util.close(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public Emp selectOne(String empid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Emp e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String empid) {
		// TODO Auto-generated method stub
		return 0;
	}

}

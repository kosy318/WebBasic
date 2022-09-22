package com.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mvc.model.vo.Board;
import com.mvc.util.DBUtil;
//BoardDAO 인터페이스 안의 메소드를 구현한 객체
//Service객체에게서 들어온 요청을 최종적으로 처리
//DB 작업을 수행(CRUD)
public class BoardDAOImpl implements BoardDAO {	
	DBUtil util;//connection 얻기...
	
	public BoardDAOImpl() {
		util = DBUtil.getInstance();
	}

	@Override
	public ArrayList<Board> selectAll() {
		String q = "select num, name, wdate, title, count from board order by num desc";
		ArrayList<Board> list = new ArrayList<Board>();
		
		try {
			Connection con = util.getConnection();
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(q);
			while(rs.next()) {
				String num = rs.getString(1);
				String name = rs.getString(2);
				String wdate = rs.getString(3);
				String title = rs.getString(4);
				int count = rs.getInt(5);
				
				Board b = new Board(num, null, name, wdate, title, null, count);
				list.add(b);
			}		
			
			util.close(rs, stat, con);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public Board selectOne(String num) {
		String q = "select num, name, wdate, title, content, count from board where num =?";
		Board b = null;
		
		try {
			Connection con = util.getConnection();
			PreparedStatement stat = con.prepareStatement(q);
			stat.setString(1, num);
			
			ResultSet rs = stat.executeQuery();
			if(rs.next()) {			
				String name = rs.getString(2);
				String wdate = rs.getString(3);
				String title = rs.getString(4);
				String content = rs.getString(5);
				int count = rs.getInt(6);				
				b = new Board(num, null, name, wdate, title, content, count);				
			}					
			util.close(rs, stat, con);			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return b;
	}

	@Override
	public void insert(Board b) {
		String q = "insert into board(pass, name, wdate, title, content,count) "
				+ " values(?,?,sysdate(),?,?,0) ";
		int x  = 0;
		try {
			Connection con = util.getConnection();
			PreparedStatement stat = con.prepareStatement(q);
			stat.setString(1, b.getPass());			
			stat.setString(2, b.getName());			
			stat.setString(3, b.getTitle());			
			stat.setString(4, b.getContent());			
			x = stat.executeUpdate();			
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}			
	}

	@Override
	public int countUp(String num) {
		String q = "update board set count = count + 1 where num = ?";
		int x  = 0;
		try {
			Connection con = util.getConnection();
			PreparedStatement stat = con.prepareStatement(q);
			stat.setString(1, num);			
			x = stat.executeUpdate();			
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}	
		
		return x;
	}

	@Override
	public int delete(String num) {
		String q = "delete from board where num =?";
		int x = 0;
		
		try {
			Connection con = util.getConnection();
			PreparedStatement stat = con.prepareStatement(q);
			stat.setString(1, num);
			
			x = stat.executeUpdate();
							
			util.close(stat, con);			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return x;
	}

}










package com.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.mvc.model.vo.Book;
import com.mvc.util.DBUtil;

public class BookDAOImpl implements BookDAO {
	
	DBUtil util;
	
	public BookDAOImpl() {
		util = DBUtil.getInstance();
	}

	@Override
	public ArrayList<Book> selectAll() {
		ArrayList<Book> list = new ArrayList<Book>();
		String sql = "select isbn, title, price, regdate from book order by regdate desc";
		
		try {
			Connection con = util.getConnection();
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				String isbn = rs.getString(1);
				String title = rs.getString(2);
				String price = rs.getString(3);
				String regdate = rs.getString(4);
				
				Book b = new Book(isbn, title, price, null, regdate);
				list.add(b);
			}
			util.close(rs, stat, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public Book selectOne(String isbn) {
		Book b = null;
		String sql = "select title, price, descript, regdate from book where isbn=?";
		
		try {
			Connection con = util.getConnection();
			PreparedStatement stat = con.prepareStatement(sql);
			stat.setString(1, isbn);
			ResultSet rs = stat.executeQuery();
			
			if(rs.next()) {
				String title = rs.getString(1);
				String price = rs.getString(2);
				String descript = rs.getString(3);
				String regdate = rs.getString(4);
				
				b = new Book(isbn, title, price, descript, regdate);
				
			}
			util.close(rs, stat, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public void insert(Book b) {
		String sql = "insert into book (isbn, title, price, descript, regdate) values (?, ?, ?, ?, sysdate())";
		
		try {
			Connection con = util.getConnection();
			PreparedStatement stat = con.prepareStatement(sql);
			stat.setString(1, b.getIsbn());
			stat.setString(2, b.getTitle());
			stat.setString(3, b.getPrice());
			stat.setString(4, b.getDescript());
			int rs = stat.executeUpdate();

			util.close(stat, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int delete(String isbn) {
		String sql = "delete from book where isbn=?";
		int rs = 0;
		
		try {
			Connection con = util.getConnection();
			PreparedStatement stat = con.prepareStatement(sql);
			System.out.println(isbn);
			stat.setString(1, isbn);
			
			rs = stat.executeUpdate();
			util.close(stat, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}

}

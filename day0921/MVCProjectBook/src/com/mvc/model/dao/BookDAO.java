package com.mvc.model.dao;

import java.util.ArrayList;

import com.mvc.model.vo.Book;

public interface BookDAO {
	
	ArrayList<Book> selectAll();
	Book selectOne(String isbn);
	void insert(Book b);
	int delete(String isbn);

}

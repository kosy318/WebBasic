package com.mvc.model.service;

import java.util.ArrayList;

import com.mvc.model.vo.Book;

public interface BookService {

	ArrayList<Book> selectAll();
	Book selectOne(String isbn);
	void insert(Book b);
	int delete(String isbn);

}

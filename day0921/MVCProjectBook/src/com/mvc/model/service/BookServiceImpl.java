package com.mvc.model.service;

import java.util.ArrayList;

import com.mvc.model.dao.BookDAO;
import com.mvc.model.dao.BookDAOImpl;
import com.mvc.model.vo.Book;

public class BookServiceImpl implements BookService {
	
	BookDAO dao;

	public BookServiceImpl() {
		dao = new BookDAOImpl();
	}
	
	@Override
	public ArrayList<Book> selectAll() {
		return dao.selectAll();
	}

	@Override
	public Book selectOne(String isbn) {
		return dao.selectOne(isbn);
	}

	@Override
	public void insert(Book b) {
		dao.insert(b);
	}

	@Override
	public int delete(String isbn) {
		return dao.delete(isbn);
	}

}

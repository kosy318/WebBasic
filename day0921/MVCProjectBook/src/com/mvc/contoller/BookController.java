package com.mvc.contoller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.model.service.BookService;
import com.mvc.model.service.BookServiceImpl;
import com.mvc.model.vo.Book;

public class BookController {
	
	BookService service;
	
	public BookController() {
		service = new BookServiceImpl();
	}

	public void list(HttpServletRequest req, HttpServletResponse resp) {
		ArrayList<Book> list = service.selectAll();
		req.setAttribute("list", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/list.jsp");
		try {
			dispatcher.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
		HttpSession session = req.getSession();
		session.removeAttribute("msg");
	}

	public void read(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String isbn = req.getParameter("isbn");
		Book b = service.selectOne(isbn);
		if(b == null)
			throw new Exception("책을 찾을 수 없습니다.");
		
		req.setAttribute("b", b);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/read.jsp");
		try {
			dispatcher.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	public void insertForm(HttpServletRequest req, HttpServletResponse resp) {
		String url = "/insertForm.jsp";
		
		HttpSession session = req.getSession();
		if(session.getAttribute("user") == null){
			url = "/loginForm.jsp";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views" + url);
		try {
			dispatcher.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	public void insertProcess(HttpServletRequest req, HttpServletResponse resp) {
		String title = req.getParameter("title");
		String isbn = req.getParameter("isbn");
		String price = req.getParameter("price");
		String descript = req.getParameter("descript");
		
		service.insert(new Book(isbn, title, price, descript, null));
		
		HttpSession session = req.getSession();
		session.setAttribute("msg", "새글 등록 성공");
		try {
			resp.sendRedirect("list.bod");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(HttpServletRequest req, HttpServletResponse resp) {
		String isbn = req.getParameter("isbn");
		
		int x = service.delete(isbn);
		try {
			if(x > 0) {
				HttpSession session = req.getSession();
				session.setAttribute("msg", "글 삭제 성공");
			} else {
				HttpSession session = req.getSession();
				session.setAttribute("msg", "글 삭제 오류 발생");
			}
		
			resp.sendRedirect("list.bod");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

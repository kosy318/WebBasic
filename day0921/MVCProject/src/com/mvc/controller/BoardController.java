package com.mvc.controller;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.model.service.BoardService;
import com.mvc.model.service.BoardServiceImpl;
import com.mvc.model.vo.Board;

// front controller에게서 요청을 넘겨받아 service에게 넘김
// 나중에 리턴되는 데이터를 받아서 jsp로 넘겨줘야함
public class BoardController {
	BoardService service; // interface type
	
	public BoardController() {
		service = new BoardServiceImpl();
	}

	public void list(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Board> list = service.selectAll();
		// jsp로 넘어가기 전에 request 객체에 결과값 저장하기
		request.setAttribute("list", list);
		
		// jsp로 화면을 넘기기(forward 방식으로)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/list.jsp");
		try {
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		session.removeAttribute("msg");
	}

	public void read(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String num = request.getParameter("num");
		Board b = service.selectOne(num);
		if(b == null) {
			throw new Exception("게시글을 찾을 수 없습니다.");
		}
		request.setAttribute("b", b);
		
		// jsp로 화면을 넘기기(forward 방식으로)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/read.jsp");
		try {
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertForm(HttpServletRequest request, HttpServletResponse response) {
		String url = "insertForm.jsp";
		String current = request.getRequestURI();
		System.out.println(current);
		
		HttpSession session = request.getSession();
		if(session.getAttribute("user") == null) { // login x, login form으로 이동
			url = "loginForm.jsp";
		}	
		// jsp로 화면을 넘기기(forward 방식으로)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/" + url);
		try {
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertProcess(HttpServletRequest request, HttpServletResponse response) {
		try {
			String title = request.getParameter("title");
			String pass = request.getParameter("pass");
			String name = request.getParameter("name");
			String content = request.getParameter("content");
			
			service.insert(new Board(null, pass, name, null, title, content, 0));
			
//			request.setAttribute("msg", "새글 등록 성공");
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/list.jsp");
//			dispatcher.forward(request, response);
			
			HttpSession session = request.getSession();
			session.setAttribute("msg", "새글 등록 성공");
			response.sendRedirect("list.bod");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(HttpServletRequest request, HttpServletResponse response) {
		try {
			String num = request.getParameter("num");
			
			service.delete(num);
			HttpSession session = request.getSession();
			session.setAttribute("msg", num + "번 글을 삭제했습니다.");
			response.sendRedirect("list.bod");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

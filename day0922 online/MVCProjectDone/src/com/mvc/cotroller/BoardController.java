package com.mvc.cotroller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.model.service.BoardService;
import com.mvc.model.service.BoardServiceImpl;
import com.mvc.model.vo.Board;
//FrontController에게서 요청을 넘겨 받아 Service에게 넘김
//나중에 리턴되는 데이터를 받아서 jsp로 넘겨줘야 함

public class BoardController {
	BoardService service;// interface type

	public BoardController() {
		service = new BoardServiceImpl();
	}

	public void list(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Board> list = service.selectAll();

		// jsp로 넘어가기 전에 request객체에 결과값 저장하기
		request.setAttribute("list", list);

		// jsp로 화면을 넘기기(forward방식으로)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/list.jsp");
		try {
			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void read(HttpServletRequest request, HttpServletResponse response) {
		String num = request.getParameter("num");
		Board b = service.selectOne(num);
		request.setAttribute("b", b);

		// jsp로 화면을 넘기기(forward방식으로)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/read.jsp");
		try {
			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void insertForm(HttpServletRequest request, HttpServletResponse response) {
		String url = "/views/insertForm.jsp";
		// String current = request.getRequestURI();

		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null) {// login x. loginForm으로 화면 전환
			url = "/views/loginForm.jsp";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);

		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	public void insertProcess(HttpServletRequest request, HttpServletResponse response) {
		try {
			String pass = request.getParameter("pass");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String name = request.getParameter("name");

			service.insert(new Board(null, pass, name, null, title, content, 0));

			request.setAttribute("msg", "글 등록 성공");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/list.bod");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void delete(HttpServletRequest request, HttpServletResponse response) {
		try {
			String num = request.getParameter("num");
			int x = service.delete(num);

			if (x > 0) {

				request.setAttribute("msg", "글 삭제 성공");
				RequestDispatcher dispatcher = request.getRequestDispatcher("list.bod");
				try {
					dispatcher.forward(request, response);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

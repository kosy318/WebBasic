package com.mvc.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 클라이언트로부터 들어오는 요청을 받아서 구분한 뒤 컨트롤러에게 넘김
// http://localhost:port/context-root/list.bod <- 전체 리스트 요청
// http://localhost:port/context-root/read.bod <- 1개를 요청
// http://localhost:port/context-root/insertForm.bod <- 새글 쓰기 화면 요청
// http://localhost:port/context-root/insertProcess.bod <- DB에 insert 요청
// 일반 컨트롤러 정보를 알고 있어야함
@WebServlet("*.bod")
public class BoardFrontController extends HttpServlet {
	
	BoardController con; // 넘길 컨트롤러 정보를 들고 있어야함
	UserController ucon;

	public BoardFrontController() {
		con = new BoardController();
		ucon = new UserController();
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 0. Client가 서버로 보내는 한글 처리
			request.setCharacterEncoding("utf-8");
			
			// 1. client가 보내는 url 구분
			String reqString = request.getServletPath();
//			System.out.println(reqString);
			
			if(reqString.equals("/list.bod")) { // 목록화면
				con.list(request, response);
			} else if(reqString.equals("/read.bod")) { // 상세보기
				con.read(request, response);
			} else if(reqString.equals("/insertForm.bod")) {
				con.insertForm(request, response);
			} else if(reqString.equals("/insertProcess.bod")) {
				con.insertProcess(request, response);
			} else if(reqString.equals("/delete.bod")) {
				con.delete(request, response);
			} else if(reqString.equals("/loginForm.bod")) { // 로그인 화면
				ucon.loginForm(request, response);
			} else if(reqString.equals("/loginProcess.bod")) { // 로그인 처리(세션에 로그인 정보 저장)
				ucon.loginProcess(request, response);
			} else if(reqString.equals("/logout.bod")) { // 로그아웃
				ucon.logout(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// error 발생시 에러 처리하는 페이지로 넘어가기
			// RequestDispatcher로 forward 시키기("/error/error.jsp")
			request.setAttribute("msg", e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/error/error.jsp");
			try {
				dispatcher.forward(request, response);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

}

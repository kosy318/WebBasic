package com.mvc.cotroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//클라이언트로부터 들어오는 요청을 받아서 구분한 뒤 컨트롤러에게 넘김
//http://localhost:port/mvc/list.bod
//http://localhost:port/mvc/read.bod
//http://localhost:port/context-root/insertForm.bod
//http://localhost:port/context-root/insertProcess.bod

@WebServlet("*.bod")
public class BoardFrontController extends HttpServlet {
	BoardController con;
	UserController ucon;//***

	public BoardFrontController() {
		con = new BoardController();
		ucon = new UserController();//***
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 0.client가 서버로 보내는 한글 처리
			request.setCharacterEncoding("utf-8");

			// 1.클라이언트가 보내는 url 구분
			String reqString = request.getServletPath();
			// System.out.println(reqString);

			if (reqString.equals("/list.bod")) {//목록화면
				con.list(request, response);

			} else if (reqString.equals("/read.bod")) {//상세보기
				con.read(request, response);

			} else if (reqString.equals("/insertForm.bod")) {
				con.insertForm(request, response);
				
			} else if (reqString.equals("/insertProcess.bod")) {
				con.insertProcess(request, response);
				
			}else if (reqString.equals("/delete.bod")) {
				con.delete(request, response);
				
			}else if (reqString.equals("/loginForm.bod")) {// 로그인화면
				ucon.loginForm(request, response);

			} else if (reqString.equals("/loginProcess.bod")) {// 로그인처리(세션에 로그인정보 저장)
				ucon.loginProcess(request, response);

			} else if (reqString.equals("/logout.bod")) {// 로그아웃
				ucon.logout(request, response);

			}
			
		} catch (Exception e) {
			e.printStackTrace();
			//error 발생시 에러 처리하는 페이지로 넘어가기
			//RequestDispatcher로 forward 시키기("/error/error.jsp")
			RequestDispatcher dispatcher = request.getRequestDispatcher("/error/error.jsp");
			dispatcher.forward(request, response);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

}

package com.mvc.contoller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//클라이언트로부터 들어오는 요청을 받아서 구분한 뒤 컨트롤러에게 넘김
@WebServlet("*.bod")
public class BookFrontController extends HttpServlet{
	BookController con;
	UserController ucon;
	
	public BookFrontController (){
		con = new BookController();
		ucon = new UserController();
	}

	private void process(HttpServletRequest req, HttpServletResponse resp) {
		try {
			// 0. Client -> Server 한글 처리
			req.setCharacterEncoding("utf-8");
			
			//  1. Client가 보내는 url 구분
			String reqString = req.getServletPath();
			System.out.println(reqString);
			
			if(reqString.equals("/list.bod")) {
				con.list(req, resp);
			} else if(reqString.equals("/read.bod")) {
				con.read(req, resp);
			} else if(reqString.equals("/insertForm.bod")) {
				con.insertForm(req, resp);
			} else if(reqString.equals("/insertProcess.bod")) {
				con.insertProcess(req, resp);
			} else if(reqString.equals("/delete.bod")) {
				con.delete(req, resp);
			} else if(reqString.equals("/loginForm.bod")) {
				ucon.loginForm(req, resp);
			} else if(reqString.equals("/loginProcess.bod")) {
				ucon.login(req, resp);
			} else if(reqString.equals("/logout.bod")) {
				ucon.logout(req, resp);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			
			req.setAttribute("msg", e.getMessage());
			RequestDispatcher dispatcher = req.getRequestDispatcher("/error/error.jsp");
			try {
				dispatcher.forward(req, resp);
			} catch (ServletException | IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
}

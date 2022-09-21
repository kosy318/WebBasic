package com.mvc.controller;

import java.io.IOException;
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

	public BoardFrontController() {
		con = new BoardController();
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) {
		// 1. client가 보내는 url 구분
		String reqString = request.getServletPath();
		// System.out.println(reqString);
		
		if(reqString.equals("/list.bod")) {
			con.list(request, response);
		} else if(reqString.equals("/read.bod")) {
			
		} else if(reqString.equals("insertForm.bod")) {
			
		} else if(reqString.equals("insertProcess.bod")) {
			
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

}

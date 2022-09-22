package com.ssafy.sample.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 맨 처음 클라이언트 요청을 받는 객체 -> 요청 구분 -> Controller에게 pass
// 요청 종류별 url 정하기
// http://localhost:8080/web_Sample/list.mvc
// http://localhost:8080/web_Sample/read.mvc
// http://localhost:8080/web_Sample/insertForm.mvc
// http://localhost:8080/web_Sample/insertProcess.mvc
// http://localhost:8080/web_Sample/delete.mvc

// http://localhost:8080/web_Sample/loginForm.mvc - 로그인화면요청
// http://localhost:8080/web_Sample/loginProcess.mvc - 세션에 로그인 정보 저장
// http://localhost:8080/web_Sample/logout.mvc
@WebServlet("*.mvc")
public class EmpFrontController extends HttpServlet {
	
	EmpController con;
	
	public EmpFrontController() {
		con = new EmpController();
	}
	
	public void process(HttpServletRequest req, HttpServletResponse resp) {
		try {
			// 1. 클라이언트로부터 들어오는 한글처리
			req.setCharacterEncoding("utf-8");
			// 2. 요청 구분을하기 위한 구분 문자열 구하기
			String reqString = req.getServletPath();
			System.out.println(reqString);
			
			if(reqString.equals("/list.mvc")) {
				con.selectAll(req, resp);
			} else if(reqString.equals("/read.mvc")){
				con.selectOne(req, resp);
			} else if(reqString.equals("/insertForm.mvc")) {
				con.insertForm(req, resp);
			} else if(reqString.equals("/insertProcess.mvc")) {
				con.insert(req, resp);
			} else if(reqString.equals("/delete.mvc")) {
				con.delete(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
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

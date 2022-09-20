package com.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieTest")
public class CookieTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		// 1. 요청 정보로부터 쿠키를 알아냄
		Cookie[] cookies = req.getCookies();
		if(cookies == null || cookies.length == 0) { // cookie 없음
			out.println("<h1>no cookie</h1>");
		} else { // cookie 있음
			out.println("<h1>cookie test</h1>");
			for(int i=0; i<cookies.length; i++) {
				Cookie c = cookies[i];
				
				String name = c.getName();
				String value = c.getValue();

				out.println(name + " : " + value + "<br>");
			}
			out.println("<hr><a href=CookieTest>다시 방문하기</a>");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 1. 클라이언트가 보낸 값을 받아 쿠키에 저장
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		// 1-1. 쿠키 생성
		Cookie idCookie = new Cookie("id", id);
		Cookie passCookie = new Cookie("pass", pass);
		
		// 1-2. 생성한 쿠키에 속성 설정
		idCookie.setMaxAge(60*60*24*365); // 쿠키의 유효기간 설정(1년)
		passCookie.setMaxAge(-1); // 브라우저를 종료 시 쿠키가 사라짐
		
		// 1-3. 생성한 쿠키를 응답객체에 담아놓기
		response.addCookie(idCookie);
		response.addCookie(passCookie);
		
		// 2. 확인 메세지 출력
		out.println("<html><body>");
		out.println("<h1>cookie가 저장되었습니다.</h1>");
		out.println("<hr><a href=CookieTest>다시 방문하기</a>");
		out.println("</body></html>");
	}

}

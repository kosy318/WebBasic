package com.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		String id = req.getParameter("id");
		
		// 1. 클라이언트를 위해 세션을 생성
		// true: 기존 세션 체크 후에 없으면 생성, 있으면 리턴
		// false : 기존 세션 체크 후에 없으면 null, 있으면 리턴
		HttpSession session = req.getSession(true); // 파라미터 안넣으면 기본이 true
		
		// 2. 세션이 처음 만들어진거라면 데이터를 저장할 자료구조 준비
		if(session.isNew()) {
			session.setAttribute("tomato", new int[] {0});
			session.setAttribute("orange", new int[] {0});
		}
		
		String msg = "";
		// 3. 세션에 접근해서 작업하기
		int[] tomato = (int[]) session.getAttribute("tomato");
		int[] orange = (int[]) session.getAttribute("orange");
		
		if(id.equals("tomato")) { // 토마토 살 경우
			tomato[0] += 1; // 토마토 개수 증가
			msg = "토마토를 쇼핑백에 추가햇습니다!";
		} else { // 오렌지 살 경우
			orange[0] += 1;
			msg = "오렌지를 쇼핑백에 추가햇습니다!";
		}
		
		msg += "<br>현재 토마토는 " + tomato[0] + "개, 오렌지는 " + orange[0] + "개 입니다.";
		
		out.println("<html><body>");
		out.println("<h1>쇼핑백 내용</h1>");
		out.println(msg + "<hr>");
		out.println("<a href=ShopServlet>쇼핑계속하기</a>");
		out.println("</body></html>");
	}
	
}

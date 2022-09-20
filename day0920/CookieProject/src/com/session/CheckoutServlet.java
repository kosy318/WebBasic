package com.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		// 1. parameter 받기
		String id = req.getParameter("id");
		
		// 2. 세션 접근을 위해 세션 얻어오기
		HttpSession session = req.getSession(false);
		if(session == null) {
			out.println("<h3>장바구니가 비었습니다.</h3>");
			out.println("<a href=ShopServlet>쇼핑하러 가기</a>");
		} else {
			String msg = "";
			int[] tomato = (int[]) session.getAttribute("tomato");
			int[] orange = (int[]) session.getAttribute("orange");
			
			if(id.equals("see")) { // 장바구니 보기
				msg = "<h3>장바구니 안의 토마토는 " + tomato[0] + "개, 오렌지는 " + orange[0] + "개 입니다.</h3>";
			} else { // 계산하기
				session.invalidate(); // 세션 삭제
				msg = "계산이 완료 되었습니다. 쇼핑백을 비웠습니다.";
			}
			
			out.println("<h1>쇼핑백</h1>");
			out.println(msg + "<hr>");
			out.println("<a href=ShopServlet>쇼핑하러 가기</a>");
		}
	}

}

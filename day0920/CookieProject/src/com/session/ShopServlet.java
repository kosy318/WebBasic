package com.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ShopServlet")
public class ShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		out.println("<html><body>");
		out.println("<h1>dada's mall</h1>");
		out.println("<a href=CartServlet?id=tomato>쇼핑백에 토마토 넣기</a> &nbsp; ");
		out.println("<a href=CartServlet?id=ornage>쇼핑백에 오렌지 넣기</a> &nbsp; ");
		out.println("<a href=CheckoutServlet?id=see>쇼핑백 보기</a> &nbsp; ");
		out.println("<a href=CheckoutServlet?id=checkout>계산하기</a> &nbsp; ");
		out.println("</body></html>");
	}
	
}

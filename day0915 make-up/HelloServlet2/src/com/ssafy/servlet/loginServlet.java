package com.ssafy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String userId = req.getParameter("userId");
		String pwd = req.getParameter("pwd");
		String gisu = req.getParameter("gisu");
		System.out.println(gisu);
		
		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append("<body>");
		if(userId.equals("ssafy") && pwd.equals("1234"))
			sb.append("<h1>").append("로그인에 성공했습니다.").append("</h1>");
		else
			sb.append("<h1>").append("로그인에 실패했습니다.").append("</h1>");
		sb.append("</body>");
		sb.append("</html>");
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = resp.getWriter();
		writer.print(sb.toString());
	}
	
}

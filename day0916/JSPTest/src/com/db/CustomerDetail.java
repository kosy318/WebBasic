package com.db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CustomerDetail")
public class CustomerDetail extends HttpServlet {
	String url = "jdbc:mysql://localhost:3306/scottdb";
	String user = "scott";
	String password = "tiger";
	String driver = "com.mysql.cj.jdbc.Driver";

	// 이 서블릿이 맨 처음 호출될 때 한번만 실행됨
	@Override
	public void init() throws ServletException {
		super.init();
		// 1. driver loading: 사용할 DB Driver 등록
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		Connection con;
		Statement stat;
		try {
			// 2. connection 생성
			con = DriverManager.getConnection(url, user, password);

			// 3. Statement 생성
			stat = con.createStatement();

			// 4. Query 실행
			String num = request.getParameter("num");
			ResultSet rs = stat.executeQuery("select name, address from customer where num=" + num);

			// 5. 결과 처리
			out.println("<h1 style='text-align:center'>Customer Detail</h1>");
			out.println("<table border=1 style='margin-left: auto; margin-right: auto;'>");

			rs.next();
			String name = rs.getString(1);
			String address = rs.getString(2);

			out.println("<tr><td>번호</td><td>" + num + "</td></tr>");
			out.println("<tr><td>이름</td><td>" + name + "</td></tr>");
			out.println("<tr><td>주소</td><td>" + address + "</td></tr>");
			out.println("</table><br>");
			
			out.println("<a href=CustomerList style='display:block text-align:center'>Back</a>");
			// 6. 마무리
			stat.close();
			con.close();

		} catch (Exception e) {
			System.out.println("error sql");
			e.printStackTrace();
		}
	}
}

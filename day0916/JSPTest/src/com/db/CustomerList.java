package com.db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CustomerList")
public class CustomerList extends HttpServlet {
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
			// DB에 문제가 생겨 네트워크가 끊어지는 경우 그 이후로 계속 사용이 불가능해지기 때문에 연결을 다시 할 수 있도록 init에 넣지 않는다.
			// 2. connection 생성
			con = DriverManager.getConnection(url, user, password);

			// 3. Statement 생성
			stat = con.createStatement();

			// 4. Query 실행
			ResultSet rs = stat.executeQuery("select num, name, address from customer");

			// 5. 결과 처리
			out.println("<h1 style='text-align:center'>Customer List</h1>");
			out.println("<table border=1 style='margin-left: auto; margin-right: auto;'>");
			
			ResultSetMetaData rsmd = rs.getMetaData(); // 제목
			int size = rsmd.getColumnCount();
			for (int i = 1; i <= size; i++) {
				String name = rsmd.getColumnName(i);
				
			}
			while (rs.next()) {
				String num = rs.getString(1);
				String name = rs.getString(2);
				out.println("<tr><td>" + num + "</td>");
				out.println("<td><a href=CustomerDetail?num=" + num + ">" + name + "</a></td></tr>");
			}
			out.println("</table><br>");
			out.println("<a href=html/CustomerInsert.html style='display:block; text-align:center'>고객등록</a>");
			

			// 6. 마무리
			stat.close();
			con.close();

		} catch (Exception e) {
			System.out.println("error sql");
			e.printStackTrace();
		}
	}
}

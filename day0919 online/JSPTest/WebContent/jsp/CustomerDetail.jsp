<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
   
<%!
	String url = "jdbc:mysql://localhost:3306/scottdb";
	String user = "scott";
	String password = "tiger";
	String driver = "com.mysql.cj.jdbc.Driver";

	public void jspInit() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
%>

<%
			Connection con = DriverManager.getConnection(url, user, password);

			Statement stat = con.createStatement();

			String num = request.getParameter("num");
			ResultSet rs = stat.executeQuery("select name, address from customer where num=" + num);
%>
			<html><body>
			<h1>Customer Detail</h1>
			<table border='1'>
			
<%
			rs.next();
			String name = rs.getString(1);
			String address = rs.getString(2);
%>
			<tr><td>번호</td><td><%= num %></td></tr>
			<tr><td>이름</td><td><%= name %></td></tr>
			<tr><td>주소</td><td><%= address %></td></tr>
			</table><br>
			
			<a href="CustomerList.jsp">Back</a>
			</body>
			</html>		

<%
			rs.close();
			stat.close();
			con.close();
%>
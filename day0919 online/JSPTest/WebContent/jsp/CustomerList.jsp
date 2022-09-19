<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>
<%!
	String url = "jdbc:mysql://localhost:3306/scottdb";
	String user = "scott";
	String password = "tiger";
	String driver = "com.mysql.cj.jdbc.Driver";

	public void jspInit() { // jsp용 init 메소드
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
%>

<%
	String query = "select num, name from customer order by num";

	Connection con = DriverManager.getConnection(url, user, password);

	Statement stat = con.createStatement();

	ResultSet rs = stat.executeQuery(query);
%>
	<html><body>
	<h1>Customer Data</h1>
	<table border='1'>

<%
	while (rs.next() == true) {
		int num = rs.getInt(1);
		String name = rs.getString(2);
%>
		<tr>
			<td><%= num %></td>
			<td><a href="CustomerDetail.jsp?num=<%= num %>"><%= name %></a></td>
		</tr>
<%	} %>
	</table><br>
	<a href=form/insert.html>새고객등록</a>
	</body>
	</html>		
	
<%
	rs.close();
	stat.close();
	con.close();
%>
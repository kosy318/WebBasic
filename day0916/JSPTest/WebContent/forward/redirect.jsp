<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	if(id.equals("tommy") && pass.equals("1234")){ // ok
		response.sendRedirect("welcome.jsp");
	} else {
		response.sendRedirect("Login.jsp");
	}
%>
</body>
</html>
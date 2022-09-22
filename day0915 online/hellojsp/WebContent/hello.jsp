<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
private String name;

public void init() {
	name = "고수연";
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Hello JSP!!!</h2>
	<h2>한글도 가능!</h2>
	<h2>Hello <%= name %></h2>
</body>
</html>
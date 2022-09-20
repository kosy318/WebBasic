<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.basic.Customer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	ArrayList<Customer> list = new ArrayList<>();
	list.add(new Customer("100", "kim", "seoul"));
	list.add(new Customer("200", "lee", "la"));
	list.add(new Customer("300", "park", "london"));
	
	request.setAttribute("list", list);
%>

<h1>customer list</h1>
<table border="1">
	<c:forEach items="${ requestScope.list }" var="c">
		<tr>
			<td>${ c.num }</td>
			<td>${ c.name }</td>
			<td>${ c.address }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>
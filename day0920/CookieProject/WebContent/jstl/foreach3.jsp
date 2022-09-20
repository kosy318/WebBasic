<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String[] movieList = {"iron man", "super man", "bat man"};

	// pageContext.setAttribute("movieList", movieList);
	request.setAttribute("movieList", movieList);
	// session.setAttribute("movieList", movieList);
	// application.setAttribute("movieList", movieList); // tomcat을 꺼야 사라짐
%>

<h1>movie name</h1>
<table border="1">
	<c:forEach items="${ movieList }" var="movie" varStatus="status">
		<tr>
			<td>${ status.count }</td>
			<td>${ movie }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>
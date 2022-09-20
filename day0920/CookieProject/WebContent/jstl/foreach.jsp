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
	<c:set var="count" value="${ param.count }"/>
	<c:forEach begin="1" end="${ count }">
		<h3>welcome...</h3>
	</c:forEach>
	
	<hr>
	
	<c:forEach begin="1" end="5" var="i">
		${ i }. hello<hr>
	</c:forEach>
</body>
</html>
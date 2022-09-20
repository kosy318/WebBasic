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
	<c:set var="id" value="${ param.id }"/>
	<c:set var="pass" value="${ param['pass'] }"/>
	
	<c:if test="${ id=='tom' and pass eq '123' }">
		<h1>welcome!</h1>
	</c:if>
	
	<c:if test="${ id!='tom' or pass ne '123' }">
		<c:redirect url="Login.jsp"/>
	</c:if>
</body>
</html>
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
	<%-- set : 변수 선언 태그 --%>
	<c:set var="num" value="${ 2+5 }"/>
	<c:set var="name" value="${ 'jane' }"/>
	
	<c:out value="${ num }"/>
	${ name }
</body>
</html>
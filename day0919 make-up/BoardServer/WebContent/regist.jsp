<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="${ pageContext.request.contextPath }/board"> <!-- board는 Board Servlet을 의미 -->
		<input type="hidden" name="act" value="regist_board">
		<label>제목: <input type="text" name="title"></label>
		<label>내용: <input type="text" name="content"></label>
		<label>작성자: <input type="text" name="userid"></label>
		<input type="submit" value="글 등록">
	</form>
</body>
</html>
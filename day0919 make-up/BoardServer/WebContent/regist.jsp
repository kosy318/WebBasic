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
	<form method="POST" action="${ pageContext.request.contextPath }/board"> <!-- board�� Board Servlet�� �ǹ� -->
		<input type="hidden" name="act" value="regist_board">
		<label>����: <input type="text" name="title"></label>
		<label>����: <input type="text" name="content"></label>
		<label>�ۼ���: <input type="text" name="userid"></label>
		<input type="submit" value="�� ���">
	</form>
</body>
</html>
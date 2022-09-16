<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Exceptin 발생!</h1>
<hr>
message : <%= exception.getMessage() %>
<hr>
<%= exception.getClass().getName() %>
</body>
</html>
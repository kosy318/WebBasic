<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>	
<meta charset="UTF-8">
</head>
<body>
	<h1>Login</h1>
	<form id ="f" method="post" action="LoginProcess.jsp">
		ID: <input type="text" name="id" id="id"><br>
		PASS: <input type="password" name="pass" id="pass"><br>	
		
		<input type="submit" value="login">		
		<input type="reset" value="cancel">
	</form>
</body>
</html>


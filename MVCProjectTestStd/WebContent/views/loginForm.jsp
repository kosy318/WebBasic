<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Bootstrap Example</title>
	<meta charset="utf-8">
	<%@ include file="/include/head.jsp" %>
</head>

<body>
	<%@ include file="/include/nav.jsp" %>	

	<div class="container text-center">
		<img src="image/f3.jpg" class="rounded-circle"/>
		<h1>Login</h1>
		<form method="post" action="loginProcess.bod">
			<div class="form-group text-left">
				<label for="id">ID:</label>
				<input type="text" class="form-control"	name="id">
			</div>
			<div class="form-group  text-left">
				<label for="pass">Password:</label> 
				<input type="password" class="form-control" name="pass">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>

</body>
</html>
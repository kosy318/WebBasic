<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<HTML>
<head>
	<%@ include file="/include/head.jsp" %>
</head>

<body>
	<%@ include file="/include/nav.jsp" %>	
	<div class="container text-center">
		<img src="image/f5.jpg" />
		<h1>새글쓰기</h1>
		<form action="insertProcess.bod" method="post">
			<div class="form-group text-left">
				<label for="title">제 목:</label> 
				<input type="text"	class="form-control" name="title">
			</div>

			<div class="form-group text-left">
				<label for="pw">패스워드:</label> 
				<input type="password"	class="form-control" name="pass">
			</div>
			<div class="form-group text-left">
				<label for="name">이 름:</label> 
				<input type="text"	class="form-control" name="name">
			</div>
			<div class="form-group text-left">
				<label for="comment">내 용:</label>
				<textarea class="form-control" rows="5" id="content" name="content"></textarea>
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
		<a href="list.bod">전체화면</a>
	</div>

</BODY>
</HTML>












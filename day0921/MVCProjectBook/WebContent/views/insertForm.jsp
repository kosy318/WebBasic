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

			<div class="form-group text-left d-flex justify-content-between">
				<label class="w-100" for="isbn">isbn:
				<input type="text"	class="form-control" name="isbn"></label> 
				<label class="w-100" for="price">가 격:
				<input type="text"	class="form-control" name="price"></label> 
			</div>
			<div class="form-group text-left">
				<label for="descript">내 용:</label>
				<textarea class="form-control" rows="5" id="descript" name="descript"></textarea>
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
		<a href="list.bod">전체화면</a>
	</div>

</BODY>
</HTML>












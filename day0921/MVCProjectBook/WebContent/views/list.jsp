<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
	<%@ include file="/include/head.jsp" %>
</head>
<body>
	<%@ include file="/include/nav.jsp" %>	


	<div class="container text-center">
	<img src="image/f1.jpg"/>
	<h1>Book List</h1>	

	<table class="table table-striped">
		<thead>
			<tr>
				<th>isbn</th>
				<th>제목</th>
				<th>가격</th>
				<th>등록 날짜</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ list }" var="b">
				<tr>
					<td>${ b.isbn }</td>
					<td><a href="read.bod?isbn=${ b.isbn}">${ b.title }</a></td>
					<td>${ b.price }</td>
					<td>${ b.regdate }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>		
	</div>
</body>
</html>




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
	<h1>MVC 게시판</h1>	

	<table class="table table-striped">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>날짜</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ list }" var="b">
				<tr>
					<td>${ b.num }</td>
					<td><a href='read.bod?num=${ b.num }'>${ b.title }</a></td>
					<td>${ b.name }</td>
					<td>${ b.wdate }</td>
					<td>${ b.count }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>		
	</div>
</body>
</html>




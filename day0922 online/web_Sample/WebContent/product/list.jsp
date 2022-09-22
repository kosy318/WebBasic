<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/include/head.jsp" %>
</head>
<body>
<%@ include file="/include/nav.jsp" %>
<div class="container text-center">
<h1>Emp List</h1>
<table class="table table-striped">
	<thead>
		<tr>
			<th>id</th>
			<th>이름</th>
			<th>부 서</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${ list }" var="e">
			<tr>
				<td>${ e.empid }</td>
				<td class="text-left"><a href="read.mvc?empid=${ e.empid }">${ e.fname }</a></td>
				<td>${ e.deptid }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
</body>
</html>
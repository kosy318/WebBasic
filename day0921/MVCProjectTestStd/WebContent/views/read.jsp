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
	<img src="image/f2.jpg"/>
		<h1>글 읽기</h1>			
	<br>
			<table class="table table-bordered"><TR>
				<TH>NUM</TH>
				<TD>111</TD>
				<Th>NAME</TH>
				<TD>222</TD>
			</TR>
			<TR>
				<TH>DATE</TH>
				<TD>333</TD>
				<TH>COUNT</TH>
				<TD>444</TD>
			</TR>
			<TR>
				<TH>TITLE</TH>
				<TD COLSPAN=3>555</TD>
			</TR>
			<TR>
				<TH>CONTENT</TH>
				<TD COLSPAN=3>
				<textarea readonly class="form-control" rows="5" id="content" name="content"></textarea>
			</td>
			</div>
			</TR>
		</TABLE>
	 <a class="btn btn-info" href="list.bod">목록</a>
	 <a class="btn btn-danger" href="delete.bod">삭제</a>
	<br><br>

	</div>
</body>
</html>







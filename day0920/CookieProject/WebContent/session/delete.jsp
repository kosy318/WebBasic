<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>세션 값 삭제</h1>
<%
	// 세션 자체를 삭제
	// session.invalidate();

	// 세션안의 데이터 값을 초기화
	session.setAttribute("id", null);
	session.setAttribute("pass", null);
	session.setAttribute("list", null);
	
	// 세션안의 속성 제거
	// session.removeAttribute("id");
	// session.removeAttribute("pass");
	// session.removeAttribute("list");
%>

<a href="Login.jsp">로그인</a> &nbsp;
<a href="check.jsp">check하러 가기</a> &nbsp;
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	if(id.equals("tommy") && pass.equals("1234")){ // ok -> welcome.jsp로 forward
%>
		<jsp:forward page="welcome.jsp"/>	<%-- 파라미터를 따로 보내줄 필요가 없음 --%>
<%	} else { %> <%-- 틀린 경우. 초기화면으로 돌아감 --%>
		<jsp:forward page="Login.jsp"/>
<%	} %>
</body>
</html>
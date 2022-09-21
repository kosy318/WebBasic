<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<ul class="navbar-nav mr-auto">
		<li class="nav-item"><a class="nav-link" href="list.bod">게시판목록</a></li>
		<li class="nav-item"><a class="nav-link" href="insertForm.bod">새글등록</a></li>
	</ul>
	<c:choose>
		<%-- session에 userInfo 객체 없는 경우(로그인 X) --%>
		<c:when test="${empty user}">
			<ul class="navbar-nav">
				<li class="nav-item">
				<a class="nav-link" href="loginForm.bod">로그인</a>
				</li>
			</ul>
		</c:when>
		
		<%-- session에 userInfo 객체 있는 경우(로그인 O) --%>
		<c:otherwise>
			<ul class="navbar-nav">
				<li class="nav-item">
					<a class="nav-link disabled">${user}님 반갑습니다.</a>
				</li>
				<li class="nav-item">
				<a class="nav-link"	href="logout.bod">로그아웃</a>
				</li>
			</ul>
		</c:otherwise>
	</c:choose>
</nav>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
	<h1>서버 메시지</h1>
	<p>${msg}</p>
	
	<c:if test="${! empty text}">
		<script>
			alert("${text}");
		</script>
		<c:remove var="text" />
	</c:if>
	
	<c:if test="${! empty user}">
		<p>${user.userid} 님 환영합니다.</p>
		<span><a href="/user/logout">[로그아웃]</a></span>
	</c:if>
	
	<c:if test="${empty user }">
		<p>로그인 하시려면 로그인 페이지로 이동하세요</p>
		<span><a href="/user/login">[로그인]</a></span>
	</c:if>
</body>
</html>

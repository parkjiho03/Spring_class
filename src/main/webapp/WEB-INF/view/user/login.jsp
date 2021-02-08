<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<style>
	* {
		margin:0;
		padding:0;
		box-sizing:border-box;
	}
	
	body {
		width:100%;
		height:100vh;
		display:flex;
		align-items:center;
		justify-content:center;
	}
	
	form {
		width:400px;
		height:500px;
	}
	
	.formContainer {
		width:100%;
	}
	
	.formContainer > input {
		width:100%;
		outline:none;
		height:40px;
		margin:10px 0;
		padding:2px 5px;
	}
	
	.btn {
		width:100%;
		height:40px;
		outline:none;
		cursor:pointer;
		background-color:#000;
		border:none;
		border-radius:5px;
		color:#fff;
	}
	
	.btn:hover {
		background-color:#000
	}
</style>
</head>
<body>
	<form method="post">
		<div style="width:100%;text-align:center;padding-bottom:30px;">
			<h2>로그인</h2>
		</div>
		<div class="formContainer">
			<p>아이디</p>
			<input type="text" name="userid" placeholder="아이디를 입력해주세요."/>
		</div>
		<div class="formContainer">
			<p>비밀번호</p>
			<input type="password" name="password" placeholder="비밀번호를 입력해주세요."/>
		</div>
		<input class="btn" type="submit" value="전송"/>
	</form>
	<c:if test="${! empty text}">
		<script>
			alert("${text}");
		</script>
		<c:remove var="text" scope="session"/>
	</c:if>
</body>
</html>
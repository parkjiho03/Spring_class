<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<body>
	<h1>회원가입</h1>
	<form method="post">
		<div>
			<p>아이디</p>
			<input type="text" name="id" />
		</div>
		<div>
			<p>비번</p>
			<input type="password" name="pass"/>
		</div>
		<div>
			<p>비번 확인</p>
			<input type="password" name="passCheck"/>
		</div>
		<div>
			<p>이름</p>
			<input type="text" name="name"/>
		</div>
		<div>
			<p>이메일</p>
			<input type="text" name="email"/>
		</div>
		
		<input type="submit" value="전송"/>
	</form>
</body>
</html>

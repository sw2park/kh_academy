<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원관리 폼</h3>
	<form action="join.jsp" method="post" id="joinForm">
		아이디 <input type="text" name="userid" id="userid"><br>
		비밀번호 <input type="password" name="userpw" id="userpw"><br>
		이름 <input type="text" name="username" id="username"><br>
		핸드폰 번호 <input type="text" name="userphone" id="userphone"><br>
		<br>
		<input type="submit" value="회원가입" onclick="sendit(); return false;">
	</form>
	<script type="text/javascript" src="util.js">
	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${param.flag == false }">
		<script>
			alert("로그인 실패! 다시 시도하세요!");
		</script>
	</c:if>
	<form action="/user/UserLoginOk.us" method="post">
		<p>아이디
			<input type="text" name="userid">
		</p>
		<p>비밀번호
			<input type="text" name="userpw">
		</p>
		<p>
			<input type="submit" value="로그인하기">
		</p>
	</form>
</body>
</html>
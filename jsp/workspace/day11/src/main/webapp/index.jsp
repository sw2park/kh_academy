<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="./app/user/joinview.jsp">회원가입</a>
	<br/>
	<a href="${pageContext.request.contextPath }/user/UserLogin.us">로그인</a>
	<!--
		로그인 버튼 클릭 시 -> frontController에 도착
		-> app/user/loginview.jsp 페이지로 이동  
	-->
</body>
</html>
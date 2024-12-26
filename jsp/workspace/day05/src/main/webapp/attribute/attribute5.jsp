<%@page import="com.kh.web.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// 세명의 아이디, 이름, 나이들을
		// attribute6.jsp로 전송 후 출력
		User[] arUser = {
				new User("admin", "홍길동", 10),
				new User("kjh", "이순신", 20),
				new User("user", "사용자", 30)
		};
		request.setAttribute("users", arUser);
		pageContext.forward("attribute6.jsp");
	%>
</body>
</html>
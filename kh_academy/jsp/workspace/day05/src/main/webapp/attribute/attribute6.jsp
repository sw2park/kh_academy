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
		// users 데이터 꺼내서, 출력
		User[]users = (User[])request.getAttribute("users");
		
		for(int i=0; i<users.length; i++){
			out.println(users[i].userid);
			out.println(users[i].username);
			out.println(users[i].age + "<br/>");
		}
	%>
</body>
</html>
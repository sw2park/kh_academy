<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	object_ok page!!!
	<%
		String username = request.getParameter("username");
		String userbitrh = request.getParameter("userbirth");
		// 비즈니스 로직...
		// ......
		
		
		// forward 방식 : request 객체가 유지
		//pageContext.forward("object_result.jsp");
		// redirect 방식 : request 객체 재생성
		response.sendRedirect("object_result.jsp");
	%>
</body>
</html>
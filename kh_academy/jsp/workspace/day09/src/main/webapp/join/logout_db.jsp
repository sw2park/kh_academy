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
	// 특정 key값의 세션값을 지워내기
	session.removeAttribute("session_id");
	// session에 저장된 모든 값을 지워내기
	//session.invalidate();
	response.sendRedirect("login_view.jsp");
%>
</body>
</html>
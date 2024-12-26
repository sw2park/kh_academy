<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.kh.web.dao.TBLMemberDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		TBLMemberDao udao = new TBLMemberDao();
		request.setAttribute("list", udao.getList());
		pageContext.forward("search_view.jsp");
	%>
</body>
</html>
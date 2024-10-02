<%@page import="com.kh.web.beans.TblMember"%>
<%@page import="com.kh.web.dao.TBLMemberDao"%>
<%@page import="java.lang.reflect.Member"%>
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
		String userid = request.getParameter("userid");
		TBLMemberDao udao = new TBLMemberDao();
		TblMember user = udao.searchById(userid);
		request.setAttribute("user", user);
		pageContext.forward("search_view.jsp");
	%>
</body>
</html>
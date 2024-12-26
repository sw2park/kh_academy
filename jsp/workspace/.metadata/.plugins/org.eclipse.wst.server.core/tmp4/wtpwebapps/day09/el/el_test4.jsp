<%@page import="java.util.ArrayList"%>
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
		ArrayList<String> result = new ArrayList<>();
		result.add("Hello");
		result.add("EL");
		result.add("JSP");
		result.add("JSTL");
		pageContext.setAttribute("result", result);
	%>
		${result }
		<%for(int i=0; i<result.size();i++){ %>
		
		<%} %>
</body>
</html>
<%@page import="com.kh.web.beans.Member"%>
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
	<jsp:useBean id="mdao" class="com.kh.web.dao.MemberDAO"/>
	<%
		ArrayList<Member> result = mdao.selectAll();
	%>
	<table border="1">
		<tr>
			<td>이름</td>
			<td>나이</td>
		</tr>
		<%for(Member member : result){ %>
			<tr>
				<td><%=member.getName() %></td>
				<td><%=member.getAge() %></td>
			</tr>
		<%} %>
	</table>
	<input type="button" value="다시 검색하기" onclick="location.href='age_search.jsp'">
</body>
</html>
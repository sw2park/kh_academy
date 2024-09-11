<%@page import="com.kh.web.dao.TblMemberDAO2"%>
<%@page import="com.kh.web.beans.TblMember"%>
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
		TblMemberDAO2 mdao = new TblMemberDAO2();
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		
		TblMember member = mdao.login(userid, userpw);
		
		if(member != null){		// 로그인 성공 
			session.setAttribute("session_id", member);
	%>
		<script type="text/javascript">
			location.href = 'main_view.jsp';
		</script>
	<%} else {								// 로그인 실패 %>
		<script type="text/javascript">
			alert("아이디 또는 패드워드를 확인해주세요!");
			location.href = 'login_view.jsp';
		</script>
	<%} %>
</body>
</html>
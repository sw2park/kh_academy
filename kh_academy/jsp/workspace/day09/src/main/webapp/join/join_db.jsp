<%@page import="com.kh.web.dao.TblMemberDAO2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--
		TblMember 객체 생성 후 파라미터로 넘어온 값 set
		MemberDAO의 join(파라미터 값) 
	 -->
	 <jsp:useBean id="member" class="com.kh.web.beans.TblMember"/>
	 <!--<jsp:setProperty property="userid" name="member"/>-->
	 <!--
	 	아래 두 코드는 같은 코드
	 	<jsp:setProperty property="userid" name="member"/>	
	 	member.setUserId(request.getParameter("userid")); 
	  -->
	  <jsp:setProperty property="*" name="member"/>
	  <!-- 외부에서 전달된 name속성과 필드의 이름이 같으면 value가 자동으로 세팅된다. -->
	  <%
	  		TblMemberDAO2 mdao = new TblMemberDAO2();
	  		if(mdao.join(member)){  // 회원가입 성공
	  %>
	  		<script type="text/javascript">
	  			alert("회원가입 성공!");
	  			location.href = "login_view.jsp";
	  		</script>
	  		<%} else { 				// 회원가입 실패 %>
  			<script type="text/javascript">
	  			alert("회원가입 실패!");
	  			location.href = "join_view.jsp";
	  		</script>
	  		<%} %>
</body>
</html>
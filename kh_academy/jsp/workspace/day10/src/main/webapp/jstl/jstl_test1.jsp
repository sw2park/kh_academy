<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>JSTL TEST</h2>
	<!-- 변수선언 -->
	<!--
		var 변수선언, value 값, scope 범위
		jstl로 만들어진 경우 el문 setAttribute로 값을 넣기 때문에 el문으로 가져올 수 있다.  
	-->
	<c:set var="userid" value="apple" scope="page"/>
	회원아이디 <c:out value="${userid }"/><br/>
	회원아이디 ${userid }<br/>
	<hr/>
	<%-- <c:set>이 사이에 들어가는 값이 value</c:set> --%>
	<c:set var="userid" scope="session">orange</c:set>
	<c:set var="username" scope="session">김자바</c:set>
	회원아이디 ${userid }<br/>
	회원 이름 ${username }<br/>
	회원아이디 ${sessionScopr.userid }<br/>
	회원 이름 ${sessionScopr.username }<br/>
</body>
</html>
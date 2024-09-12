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
	<%--
		만약, param.userid값이 없으면 
		<form>를 화면에 보여주기
		그렇지 않다면, 화면에 userid값, userpw값을 출력
	 --%>
	<c:choose>
		<c:when test="${empty param.userid }">
			<form>
				아이디 <input type="text" name="userid"/><br/>
				패스워드 <input type="password" name="userpw"/><br/>
				<input type="submit">
			</form>
		</c:when>
			<c:otherwise>
				<c:set var="userid" value="${param.userid }"/>
				<c:choose>
					<c:when test="${userid == 'admin' }">
						관리자
					</c:when>
					<c:when test="${userid == 'apple' }">
						김사과
					</c:when>
					<c:otherwise>비회원</c:otherwise>
				</c:choose>
			</c:otherwise>
	</c:choose>
</body>
</html>
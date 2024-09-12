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
	<h2>JSTL TEST2(제어문-조건문)</h2>
	<c:set var="num" value="100"/>
	<!-- num > 50 과 동일  -->
	<c:if test="${num gt 50 }">
		<script type="text/javascript">
			alert("이 수는 50보다 크다");
		</script>
	</c:if>
		<c:if test="${num gt 30 }">
		<script type="text/javascript">
			alert("이 수는 30보다 크다");
		</script>
	</c:if>
	
	choose문 사용
	(if~else 문의 경우 jstl에서는 choose를 사용하여 구성한다.)
	<br/>
	<c:choose>
		<c:when test="${num gt 50 }">
			이수는 50보다 크다!
		</c:when>
		<c:when test="${num gt 30 }">
			이수는 30보다 크다!
		</c:when>
		<c:when test="${num gt 10 }">
			이수는 10보다 크다!
		</c:when>
		<c:otherwise>	
			이 숫자는 그 외의 숫자이다!
		</c:otherwise>
	</c:choose>
</body>
</html>
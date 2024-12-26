<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	a:visited{
		color:#ce93d8;
		text-decoration:none;
	}
	a:hover{
		color:#ce93d8;
		text-decoration:none;
		font-weight:bold;
	}
	a:link {
		color:#ce93d8;
		text-decoration:none;
	}
	table{
		margin: 0 auto;
	}
</style>
</head>
<body>
	<a href="/board/BoardWrite.bo">[글 쓰기]</a><br/>
	<a href="${pageContext.request.contextPath}/board/BoardList.bo">[글 목록]</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Ajax 요청 보내기</h3>
	<input type="submit" value="GET방식으로 보내기" onclick="send1()">
	<input type="submit" value="POST방식으로 보내기" onclick="send2()">
	<p id="result"></p>
	<script type="text/javascript" src="ajax.js"></script>
</body>
</html>
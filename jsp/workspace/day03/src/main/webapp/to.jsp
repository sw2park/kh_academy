<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 파라미터 받기
	String ans = request.getParameter("ans");
	// 화면에 출력할 결과 문자열
	String result = null;
	
	if(ans == null){
		// 파라미터가 없다면 
		result = "응답 내용이 없습니다.";
	} else {
		// 파라미터가 명시된 경우
		int user_select = Integer.parseInt(ans);
		if(user_select == 300){
			result = "정답입니다.";
		} else {
			result = "정답이 아닙니다.";
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>응답결과</h1>
	<p><%=result %></p>
</body>
</html>
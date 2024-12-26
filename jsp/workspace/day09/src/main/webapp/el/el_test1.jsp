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
		// 자바변수로 등록된 값을 그대로 사용하면 보이지 않는다.
		String data = "hello";
		// page에 저장
		pageContext.setAttribute("data", data);
	%>
	\${data } : ${data }<br/>
	${10+20 }<br/>
	${10 > 3 }
</body>
</html>
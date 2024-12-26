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
		pageContext.setAttribute("result", "hello");
	%>
	<%-- <%=request.getParameter("result") %>입니다.<br/> --%>
	<%-- <%=request.getAttribute("result") %>입니다.<br/> --%>
	${requestScope.result }입니다.<br/>
	${result }<br/>
	
	<%-- ${names[0] }<br/>
	${names[1] }<br/>
	
	${notice.id }<br/>
	${notice.title }<br/> --%>
	
</body>
</html>
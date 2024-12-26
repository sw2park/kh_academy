<%@page import="com.kh.web.dao.AdminDAO"%>
<%@page import="com.kh.web.vo.AdminDTO"%>
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
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		String username = request.getParameter("username");
		String userphone = request.getParameter("userphone");
		
		// data setting
		AdminDTO aDto = new AdminDTO();
		aDto.setUserid(userid);
		aDto.setUserpw(userpw);
		aDto.setUsername(username);
		aDto.setUserphone(userphone);
		
		AdminDAO aDao = new AdminDAO();
		boolean check = aDao.join(aDto);
		if(check){
			// 가입 성공 경우 이동할 페이지
		} else {
			// 가입 실패 경우 이동할 페이지
		}
	%>
</body>
</html>
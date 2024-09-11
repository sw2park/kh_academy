<%@page import="com.kh.web.dao.TblMemberDAO2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userid = request.getParameter("userid");
	TblMemberDAO2 mdao = new TblMemberDAO2();
	// 아이디 중복 값 -> true, 중복값이 아니면 -> false
	if(!mdao.checkId(userid)){
		// 회원가입 가능한 아이디일 경우
		out.print("ok");
	} else {
		// 회원가입 불가능한 중복된 아이디일 경우
		out.print("not-ok");
	}
%>

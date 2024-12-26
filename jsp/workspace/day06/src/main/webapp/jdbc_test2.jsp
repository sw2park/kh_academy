<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
	Connection conn = null;

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user ="jsp";
	String password = "jsp";
	
	try{
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, password);
		
		// sql문 선언용 변수
		String sql = "SELECT SYSDATE FROM DUAL";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		// pstm의 결과값을 rs에 담음
		ResultSet rs = pstm.executeQuery();
		
		if(rs.next()){
			// 브라우저에 출력
			out.print(rs.getDate(1));
		}
	}catch(Exception e){
		System.out.println("예외상황 발생");
		e.printStackTrace();
	}
%>
</body>
</html>
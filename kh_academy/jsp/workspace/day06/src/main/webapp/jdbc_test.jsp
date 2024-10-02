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
	// db connection 객체 생성
	Connection conn = null;
	// db connection에 필요한 정보
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user ="jsp";
	String password = "jsp";
	
	int check = 0;
	try{
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, password);
		// 오라클 연결 성공
		
		String sql = "INSERT INTO CAR c VALUES ('3', 'k7', 'White', 70000000)";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		/*
			insert, update, delete : 적용된 건수 return
			select : 조회한 건수를 return 
		*/
		check = pstm.executeUpdate();
		System.out.println("check : " + check);
		
		if(check != 0){
			System.out.println("데이터 삽입 성공!");	
		} else {
			System.out.println("데이터 삽입 실패!");
		}
		
	}catch(Exception e){
		System.out.println("예외상황 발생");
		e.printStackTrace();
	}
%>
</body>
</html>
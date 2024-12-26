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
		
		String carnum = "2";
		// sql문 선언용 변수
		String sql
		// = "SELECT * FROM CAR WHERE CARNUM = '" + carnum + "'"; // 너무 복잡해 보여서 사용 X
		= "SELECT COLOR FROM CAR WHERE CARNUM = ?"; // 파라미터 정의
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		pstm.setString(1, carnum); // 1번째 ?에다가 파라미터값으로 carnum을 넣음 
		
		// pstm의 결과값 실행
		ResultSet rs = pstm.executeQuery();
		
		if(rs.next()){
			out.print("컬러 : " + rs.getString(1));
		}
		
	}catch(Exception e){
		System.out.println("예외상황 발생");
		e.printStackTrace();
	}
%>
</body>
</html>
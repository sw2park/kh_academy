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
		String sql = "SELECT * FROM CAR";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		// pstm의 결과값을 rs에 담음
		ResultSet rs = pstm.executeQuery();
		
		// 다음행이 없을때까지 반복문 진행
		while(rs.next()){
			out.print("차번호 : " + rs.getString(1) + ","); // 컬럼 번호로 가져오기
			out.print("브랜드 : " + rs.getString("BRAND") + ","); // 컬럼 명칭으로 가져오기
			out.print("색상 : " + rs.getString(3) + ",");
			out.print("가격 : " + rs.getInt("PRICE") + "원<br/>"); // db에서 int로 선언되어서 getInt를 사용해야함. 데이터 타입 맞춰야함
		}
		
	}catch(Exception e){
		System.out.println("예외상황 발생");
		e.printStackTrace();
	}
%>
</body>
</html>
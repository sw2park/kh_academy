package com.kh.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.web.beans.Member;

public class MemberDAO {
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	
	// 사용자가 입력한 이름값으로 나이를 db에서 조회해서 return
	public int getAge(String name) {
		int age = 0;
		
		String sql = "SELECT AGE FROM MEMBER WHERE NAME = ?";
		
		try {
			conn = DBConnection.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, name);
			ResultSet rs = pstm.executeQuery();
			
			if(rs.next()) {
				age = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			System.out.println("SQL 구문 예외 상황 발생");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("알 수 없는 예외 상황 발생");
			e.printStackTrace();
		}
		return age;
	}
	
	public ArrayList<Member> selectAll(){
		ArrayList<Member> result = new ArrayList<Member>();
		
		String sql = "SELECT * FROM MEMBER";
		
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				Member member = new Member();
				member.setName(rs.getString(1));	// name
				member.setAge(rs.getInt(2));		// age
				result.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
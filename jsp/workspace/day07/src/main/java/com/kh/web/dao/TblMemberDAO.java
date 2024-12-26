package com.kh.web.dao;

import java.io.Console;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.web.beans.TblMember;

public class TblMemberDAO {
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	
	// 회원가입 - insert
	public boolean join(TblMember member) {
		boolean result = false;
		
		String sql = "INSERT INTO TBL_MEMBER VALUES(?,?,?,?,?)";
		
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, member.getUserid());
			pstm.setString(2, member.getUserpw());
			pstm.setString(3, member.getUsername());
			pstm.setString(4, member.getUsergender());
			pstm.setString(5, member.getUserphone());
			
			int returnNum = pstm.executeUpdate();
			
			if(returnNum == 1) {	// 성공했을시
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 로그인 처리 -> select
	public TblMember login(String userid, String userpw) {
		//boolean result = false;
		TblMember member = null;
		
		String sql = "SELECT * FROM TBL_MEMBER WHERE USERID = ? AND USERPW = ?";
		
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, userid);
			pstm.setString(2, userpw);
			
			rs = pstm.executeQuery();
			
			if(rs.next()) {
				member = new TblMember();
				member.setUserid(rs.getString(1));
				member.setUserpw(rs.getString(2));
				member.setUsername(rs.getString(3));
				member.setUsergender(rs.getString(4));
				member.setUserphone(rs.getString(5));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return member;
	}
}

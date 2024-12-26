package com.kh.web.user.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.kh.mybatis.SqlMapConfig;

public class UserDAO {
	SqlSessionFactory factory = SqlMapConfig.getFactory();
	SqlSession session;
	
	public UserDAO() {
		session = factory.openSession(true);
	}
	
	// 회원가입
	public boolean join(UserDTO user) {
		boolean result = false;
		if (session.insert("User.join", user) == 1) {
			result = true;
		} 
		
		return result;
	}
	
	// 로그인 메서드
	public boolean login(String userid, String userpw) {
		boolean result = false; 
		
		HashMap<String, String> datas = new HashMap<>();
		
		datas.put("userid", userid);
		datas.put("userpw", userpw);
		
		if((Integer)session.selectOne("User.login", datas) == 1) {
			result = true;
		}
		
		return result;
	}
}

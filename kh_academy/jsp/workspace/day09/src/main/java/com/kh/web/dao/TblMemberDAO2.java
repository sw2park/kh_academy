package com.kh.web.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.kh.mybatis.SqlMapConfig;
import com.kh.web.beans.TblMember;

public class TblMemberDAO2 {
	SqlSessionFactory factory = SqlMapConfig.getFactory();
	SqlSession sqlSession;
	
	public TblMemberDAO2() {
		sqlSession = factory.openSession(true);
	}
	
	// id 중복 체크
	public boolean checkId(String userid) {
		boolean result = false;
		int cnt = 0;
		// 리턴되는 값이 한 건일 때 selectOne 사용
		// xml파일의 namespace를 파라미터
		cnt = sqlSession.selectOne("Member.checkId", userid);
		
		if(cnt == 1) {
			result = true;
		}
		return result;
	}
	
	// 회원가입
	public boolean join(TblMember member) {
		boolean result = false;
		
		if(sqlSession.insert("Member.join", member) == 1) {
			result = true;
		}
		return result;
	}
	
	public TblMember login(String userid, String userpw) {
		TblMember member = null;
		HashMap<String, String> datas = new HashMap<>();
		datas.put("userid", userid);
		datas.put("userpw", userpw);
		
		member = sqlSession.selectOne("Member.login", datas);
		
		return member;
	}
}
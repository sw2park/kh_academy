package com.kh.web.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.kh.mybatis.SqlMapConfig;
import com.kh.web.beans.TblMember;

public class TBLMemberDao {
	SqlSessionFactory factory = SqlMapConfig.getFactory();
	SqlSession sqlSession;
	
	public TBLMemberDao() {
		sqlSession = factory.openSession(true);
	}
	
	// 회원 1명 검색
	public TblMember searchById(String userid) {
		return (TblMember)sqlSession.selectOne("Member.searchById", userid);
	}
	
	// 전체 회원 검색
	public List<TblMember> getList(){
		return sqlSession.selectList("Member.getList");
	}
}

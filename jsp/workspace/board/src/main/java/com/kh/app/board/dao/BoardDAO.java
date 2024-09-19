package com.kh.app.board.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.kh.mybatis.SqlMapConfig;

public class BoardDAO {
	SqlSessionFactory factory = SqlMapConfig.getFactory();
	SqlSession session;
	
	public BoardDAO() {
		session = factory.openSession(true);
	}
	
	public List<BoardDTO> getBoardList(int startRow, int endRow){
		// sql에 파라미터 전달용 HashMap
		HashMap<String, Integer> datas = new HashMap<>();
		datas.put("startRow", startRow);
		datas.put("endRow", endRow);
		
		List<BoardDTO> boardList = new ArrayList<>();
		boardList = session.selectList("Board.getBoardList", datas);
		return boardList;
	}
	
	public int getBoardCnt() {
		return session.selectOne("Board.getBoardCnt");
	}
}

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

	public boolean insertBoard(BoardDTO board) {
		boolean result = false;
		
		if(session.insert("Board.insertBoard", board) == 1 ) {
			result = true;
		}
		return result;
	}

	public BoardDTO getDetail(int boardnum) {
		return (BoardDTO)session.selectOne("Board.getDetail", boardnum);
	}

	public void updateReadCount(int boardnum) {
		session.update("Board.updateReadCount", boardnum);
	}

	public int getSeq() {
		return session.selectOne("Board.getSeq");
	}

	public boolean addReply(ReplyDTO reply) {
		boolean result = false;
		
		if(session.insert("Board.addReply", reply) == 1) {
			result = true;
		}
		return result;
	}

	public List<ReplyDTO> getReplys(int boardnum) {
		return session.selectList("Board.getReplys", boardnum);  
	}

	public boolean updateReply(int replynum, String replycontents) {
		boolean result = false;
		HashMap<String, Object> datas = new HashMap<String, Object>();
		datas.put("replynum", replynum);
		datas.put("replycontents", replycontents);
		
		if(session.update("Board.updateReply", datas) == 1) {
			result = true;
		}
		return result;
 	}

	public boolean deleteReply(int replynum) {
		boolean result = false;
		
		if(session.delete("Board.deleteReply", replynum) == 1) {
			result = true;
		}
		return result;
	}
}

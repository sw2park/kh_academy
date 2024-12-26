package com.kh.app.board;

import com.kh.app.board.dao.BoardDAO;
import com.kh.app.board.dao.BoardDTO;
import com.kh.web.action.Action;
import com.kh.web.action.ActionForward;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardWriteOkAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		BoardDAO bdao = new BoardDAO();
		BoardDTO board = new BoardDTO();
		
		// boardwrite.jsp에서 넘어온 name값 설정
		String boardtitle = req.getParameter("boardtitle");
		String username = req.getParameter("username");
		String boardcontents = req.getParameter("boardcontents");
		
		// xml에 보낼 파라미터 세팅
		board.setBoardtitle(boardtitle);
		board.setBoardcontents(boardcontents);
		board.setUsername(username);
		
		forward.setRedirect(true);
		
		if(bdao.insertBoard(board)) {	//성공시
			// boardnum seq를 조회
			int boardnum = bdao.getSeq();
			// 성공한 글의 게시글 상세보기
			forward.setPath("/board/BoardView.bo?boardnum="+boardnum);
		} else { 						//실패시
			forward.setPath("/board/BoardWrite.bo?flag=false");
		}
		
		return forward;
	}
}
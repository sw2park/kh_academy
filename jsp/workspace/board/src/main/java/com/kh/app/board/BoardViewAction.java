package com.kh.app.board;

import com.kh.app.board.dao.BoardDAO;
import com.kh.app.board.dao.BoardDTO;
import com.kh.web.action.Action;
import com.kh.web.action.ActionForward;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardViewAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		BoardDAO bDao = new BoardDAO();
				
		int boardnum = Integer.parseInt(req.getParameter("boardnum")); 
		
		// 조회수 update
		bDao.updateReadCount(boardnum);
		
		// 댓글 조회
		req.setAttribute("replylist", bDao.getReplys(boardnum));
		req.setAttribute("board", bDao.getDetail(boardnum)); 
		forward.setRedirect(false);
		forward.setPath("/app/board/boardview.jsp");
		
		return forward;
	}
}

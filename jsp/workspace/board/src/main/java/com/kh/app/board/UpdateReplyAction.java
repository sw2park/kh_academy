package com.kh.app.board;

import com.kh.app.board.dao.BoardDAO;
import com.kh.web.action.Action;
import com.kh.web.action.ActionForward;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateReplyAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		BoardDAO bDao = new BoardDAO();
		
		int replynum = Integer.parseInt(req.getParameter("replynum"));
		
		String replycontetns = req.getParameter("reply" + replynum);
		String boardnum = req.getParameter("boardnum");
		
		if (bDao.updateReply(replynum, replycontetns)) {
			forward.setRedirect(true);
			// 상세보기 페이지
			forward.setPath("/board/BoardView.bo?boardnum="+boardnum);
		}
		
		return forward;
	}
}

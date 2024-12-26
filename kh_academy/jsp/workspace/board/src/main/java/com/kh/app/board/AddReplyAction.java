package com.kh.app.board;

import com.kh.app.board.dao.BoardDAO;
import com.kh.app.board.dao.ReplyDTO;
import com.kh.web.action.Action;
import com.kh.web.action.ActionForward;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddReplyAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		ReplyDTO reply = new ReplyDTO();
		BoardDAO bDao = new BoardDAO();
		
		String replycontents = req.getParameter("replycontents");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		int boardnum = Integer.parseInt(req.getParameter("boardnum"));
		
		reply.setReplycontents(replycontents);
		reply.setUsername(username);
		reply.setPassword(password);
		reply.setBoardnum(boardnum);
		
		forward.setRedirect(true);
		
		if(bDao.addReply(reply)) {
			forward.setRedirect(true);
			forward.setPath("/board/BoardView.bo?boardnum="+boardnum);
		} else {
			forward.setPath("/board/BoardView.bo?boardnum="+boardnum);
		}
		
		return forward;
	}
}
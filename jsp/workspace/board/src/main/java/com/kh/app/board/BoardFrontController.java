package com.kh.app.board;

import java.io.IOException;

import com.kh.web.action.ActionForward;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("*.bo")
public class BoardFrontController extends HttpServlet {
	// doGet, doPost, doProcess
	// /board/BoardList.bo 요청으로 왔을때(request)
	// /app/board/boardlist.jsp 페이지
	// 응답으로 보내주기 (response)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURI = req.getRequestURI(); 
		ActionForward forward = null;
		
		switch (requestURI) {
		case "/board/BoardList.bo": 
//			forward = new ActionForward(true, req.getContextPath() + "/app/board/boardlist.jsp");
			forward = new BoardListAction().execute(req, resp);
			break;
		case "/board/BoardWrite.bo": 
			forward = new ActionForward(true, "/app/board/boardwrite.jsp");
			break;
		case "/board/BoardWriteOk.bo":
			forward = new BoardWriteOkAction().execute(req, resp);
			break;
		case "/board/BoardView.bo":
			forward = new BoardViewAction().execute(req, resp);
			break;
		case "/board/AddReply.bo":
			// insert
			forward = new AddReplyAction().execute(req, resp);
			break;	
		case "/board/UpdateReply.bo":
			forward = new UpdateReplyAction().execute(req, resp);
			break;
		case "/board/DeleteReply.bo":
			forward = new DeleteReplyAction().execute(req, resp);
			break;
		}
		
		// 페이지 이동에 대한 일괄 처리
		if(forward != null) {
			if(forward.isRedirect()) {
				// true, redirect 방식으로 페이지 이동할 경우
				resp.sendRedirect(forward.getPath());
			} else {
				// false, forward 방식으로 페이지 이동할 경우 
				req.getRequestDispatcher(forward.getPath()).forward(req, resp);
			}
		}
	}
}
package com.kh.app.board;

import java.util.HashMap;

import com.kh.app.board.dao.BoardDAO;
import com.kh.web.action.Action;
import com.kh.web.action.ActionForward;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BoardListAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		// db조회, /app/board/boardlist.jsp
		ActionForward forward = new ActionForward();
		// BoardDAO 객체생성
		BoardDAO bdao = new BoardDAO();
		
		// 페이징 처리 시작
		// 넘겨받은 페이지
		String temp = req.getParameter("page");
		int page = 0;
		
		// 아래 if문과 동일
		page = temp == null ? 1 : Integer.parseInt(temp);
		
//		if( temp == null) {
//			page = 1;
//		} else {
//			page = Integer.parseInt(temp);
//		}
		
		// 전체 게시글 개수
		int totalCnt = bdao.getBoardCnt();
		
		// 페이징 처리 [1][2]...[10]
		int pageSize = 10;
		// 1페이지의 endRow = 10, 4페이지의 endRow = 40
		int endRow = page * 10; 
		// 1페이지의 startRow = 1, 4페이지의 startRow = 31
		int startRow = endRow - 9;
		// [1][2]...[10] : [1], [11][12]...[20] : [11]   
		int startPage = (page - 1) / pageSize * pageSize + 1;
		// [1][2]...[10] : [10], [11][12]...[20] : [20]   
		int endPage = startPage + pageSize - 1;
		int totalPage = (totalCnt-1)/pageSize+1;
		
		endPage = endPage > totalPage ? totalPage : endPage;
		
		// 페이징 처리에 필요한 부분
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("nowPage", page);
		req.setAttribute("startPage", startPage);
		req.setAttribute("endPage", endPage);		
		
		// request에 getBoardList에서 받아온 객체 데이터를 키값으로 설정
		req.setAttribute("boardList", bdao.getBoardList(startRow, endRow));
		req.setAttribute("totalCnt", totalCnt);
		// path 설정
		forward.setPath("/app/board/boardlist.jsp");
		forward.setRedirect(false); // false가 forward 이동
		
		
		return forward;
	}
}

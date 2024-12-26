package com.kh.web.user;

import com.kh.web.action.Action;
import com.kh.web.action.ActionForward;
import com.kh.web.user.dao.UserDAO;
import com.kh.web.user.dao.UserDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserLoginOkAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		UserDAO udao = new UserDAO();
		
		String userid = req.getParameter("userid");
		String userpw = req.getParameter("userpw");
		
		forward.setRedirect(true);
		if (udao.login(userid, userpw)) {
			// 로그인 성공
			forward.setPath("/app/main/mainview.jsp");
		} else {
			// 로그인 실패
			forward.setPath("/app/user/loginview.jsp?flag=false");
		}
		
		// 파라미터 값 세팅
		return forward;
	}
	
}

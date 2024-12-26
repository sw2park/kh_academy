package com.kh.web.user;

import com.kh.web.action.Action;
import com.kh.web.action.ActionForward;
import com.kh.web.user.dao.UserDAO;
import com.kh.web.user.dao.UserDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserJoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		ActionForward forward = new ActionForward();
		UserDTO user = new UserDTO();
		UserDAO udao = new UserDAO();
		
		// 파라미터값 setting
		user.setUserid(req.getParameter("userid"));
		user.setUserpw(req.getParameter("userpw"));
		user.setUsername(req.getParameter("username"));
		user.setUserphone(req.getParameter("userphone"));
		user.setUseraddr(req.getParameter("useraddr"));
		
		if(udao.join(user)) {
			// 회원가입 성공
			forward.setRedirect(true); 
			forward.setPath("/app/user/loginview.jsp");
		} else {
			// 회원가입 실패
			forward.setRedirect(true);
			forward.setPath("/index.html");
		}
		
		// dao, db insert, mybatis
		// dto(vo, beans) setting
		
		return forward;
	}
	
}
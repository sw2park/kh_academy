package com.kh.web.user;

import java.io.IOException;

import com.kh.web.action.ActionForward;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("*.us")
public class UserFrontController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		ActionForward forward = new ActionForward();
		
		if(requestURI.equals("/user/UserJoin.us")) {
			forward = new UserJoinAction().execute(req, resp);
		} else if (requestURI.equals("/user/UserLogin.us")) {
			forward = new ActionForward(false, "/app/user/loginview.jsp");
		} else if (requestURI.equals("/user/UserLoginOk.us")) {
			// 비즈니스 로직 처리할 UserLoginOkAction.java
			// 로그인 성공 -> /app/main/mainview.jsp
			// 로그인 실패 -> /app/user/loginview.jsp
			forward = new UserLoginOkAction().execute(req, resp);
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

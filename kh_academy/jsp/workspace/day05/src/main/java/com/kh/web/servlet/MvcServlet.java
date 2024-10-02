package com.kh.web.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/mvc2")
public class MvcServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num=0;
		String num_ = req.getParameter("num");
		if(num_ != null && !num_.equals("")){
			num = Integer.parseInt(num_);
		}
		
		String result = "";
		if(num % 2 != 0){
			result = "홀수";
		} else {
			result = "짝수";
		}
		req.setAttribute("result", result);
		
		// RequestDispatcher : 요청을 보내주는 인터페이스 
		RequestDispatcher dispatcher = req.getRequestDispatcher("mvc2.jsp");
		dispatcher.forward(req, resp);
	}
	
}
package com.kh.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// session 객체 획득
		HttpSession session = arg0.getSession();
		
		PrintWriter out = arg1.getWriter();
		
		String value_ = arg0.getParameter("value");
		String op = arg0.getParameter("operator");
		
		int value = 0;
		if(value_ != null && !value_.equals("")) {
			value = Integer.parseInt(value_);
		}
		
		if(op.equals("=")) {	// 계산
			// "5", "+"를 session 각각 꺼내오기
			int x = (Integer)session.getAttribute("value");
			String operator = (String)session.getAttribute("op");
			
			// 새로운 request에서 꺼내온 "6", "="과 연산
			int result = 0;
			
			if(operator.equals("+")) {
				result = x + value;
			} else {
				result = x - value;
			}
			
			out.printf("결과 값 : %d\n", result);
			
		} else {				// session 저장
			session.setAttribute("value", value);
			session.setAttribute("op", op);
		}
	}
}

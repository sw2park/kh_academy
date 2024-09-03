package com.kh.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/calc2")
public class CalcServlet2 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// 쿠키 객체에서 꺼내오기, "5", "+"
		Cookie[] cookies = arg0.getCookies();
		
		PrintWriter out = arg1.getWriter();
		
		String value_ = arg0.getParameter("value");
		String op = arg0.getParameter("operator");
		
		int value = 0;
		if(value_ != null && !value_.equals("")) {
			value = Integer.parseInt(value_);
		}
		
		if(op.equals("=")) {	// 계산
			// "5", "+"를 cookies에서 꺼내고
			int x = 0;
			// cookies 꺼내기
			// "5" 꺼내기
			for(Cookie e : cookies) {
				if(e.getName().equals("value")) {	// 5
					x = Integer.parseInt(e.getValue());
					break;
				}
			}
			
			// "+" 꺼내기
			String operator = "";
			for(Cookie e : cookies) {
				if(e.getName().equals("op")) {
					operator = e.getValue();
					break;
				}
			}
			
			// "6", "="를 request에서 꺼낸 결과를 연산
			int result = 0;
			if(operator.equals("+")) {
				result = x + value;
			} else {
				result = x - value;
			}
			out.printf("결과 값 : %d\n", result);
		} else {				// cookie 저장
			Cookie valueCookie = new Cookie("value", String.valueOf(value));	// 5
			Cookie opCookie = new Cookie("op", op);		// +
			
			// 사용자에게 cookie 전달되도록 response 객체에 담아준다
			arg1.addCookie(valueCookie);
			arg1.addCookie(opCookie);
			
			// 페이지 이동
			arg1.sendRedirect("calc.html");
		}
	}
}

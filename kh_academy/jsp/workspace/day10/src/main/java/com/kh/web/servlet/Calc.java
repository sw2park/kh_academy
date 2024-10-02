package com.kh.web.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Calc")
public class Calc extends HttpServlet{
	/*
	 *  /Calc 요청을 받아주는 servlet 생성
	 *  2개의 파라미터 data1, data2, int 값으로 할당
	 *  만약, num2의 값이 0이면 
	 *  result 값에 "0으로는 나눌 수 없습니다."
	 *  그렇지 않다면, result 키값에 num1/num2 결과값을 담아서
	 *  c.jsp forward 이동
	 *  arg0.getRequestDispatcher("c.jsp".forward(arg0, arg1);
	 */
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		int num1 = Integer.parseInt(arg0.getParameter("data1")); 
		int num2 = Integer.parseInt(arg0.getParameter("data2"));
		
		double result = 0.0;

		if(num2 == 0) {
			arg0.setAttribute("result", "0으로는 나눌 수 없습니다.");
		} else {
			result = num1/num2;
			arg0.setAttribute("result", result);
		}
		arg0.getRequestDispatcher("c.jsp").forward(arg0, arg1);
	}
}

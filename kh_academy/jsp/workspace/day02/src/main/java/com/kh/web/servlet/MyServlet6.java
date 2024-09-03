package com.kh.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class MyServlet6 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String xStr = arg0.getParameter("x");
		String yStr = arg0.getParameter("y");
		String operType = arg0.getParameter("operator");
		
		int x = 0;
		int y = 0;
		int result = 0;
		
		if(xStr != null && !xStr.equals("")) {
			x = Integer.parseInt(xStr);			
		}
		if(yStr != null && !yStr.equals("")) {
			y = Integer.parseInt(yStr);			
		}

		if(operType.equals("덧셈")) {
			result = x+y;
		} else if(operType.equals("뺄셈")) {
			result = x-y;
		}
		arg1.getWriter().printf("result is %d\n", result);
	}
}
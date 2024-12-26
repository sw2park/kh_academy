package com.kh.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class MyServlet5 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String xStr = arg0.getParameter("x");
		String yStr = arg0.getParameter("y");
		
		int x = 0;
		int y = 0;
		
		if(xStr != null && !xStr.equals("")) {
			x = Integer.parseInt(xStr);			
		}
		if(yStr != null && !yStr.equals("")) {
			y = Integer.parseInt(yStr);			
		}
		
		int result = x + y;
		arg1.getWriter().printf("result is %d\n", result);
	}
}
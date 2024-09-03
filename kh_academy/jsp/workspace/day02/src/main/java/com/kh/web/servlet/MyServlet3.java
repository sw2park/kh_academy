package com.kh.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// /cnt?cnt=5
@WebServlet("/cnt")
public class MyServlet3 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		arg1.setCharacterEncoding("UTF-8");
		arg1.setContentType("text/html; charser=UTF-8");
		PrintWriter out = arg1.getWriter();
		
//		int cnt = Integer.parseInt(arg0.getParameter("cnt"));
		
		String paramCnt = arg0.getParameter("cnt");
		int cnt = 100;
		
		if(paramCnt != null && !paramCnt.equals("")) {
			cnt = Integer.parseInt(paramCnt);
		}
		
		for(int i=0; i<cnt; i++) {
			out.println((1+i) + " : 안녕 Servlet!!<br/>");
		}
	}
}
package com.kh.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// /cnt?cnt=5
@WebServlet("/regit")
public class MyServlet4 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
//		arg0.setCharacterEncoding("UTF-8");
//		
//		arg1.setCharacterEncoding("UTF-8");
//		arg1.setContentType("text/html; charser=UTF-8");
		PrintWriter out = arg1.getWriter();
		
		String title = arg0.getParameter("title");
		String content = arg0.getParameter("content");

		out.print(title + "<br/>");
		out.print(content);
	}
}
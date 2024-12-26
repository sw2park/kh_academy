package com.kh.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class CalcServlet2 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET 요청");
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("POST 요청");
		doProcess(req, resp);
	}
	
	protected void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		int num1 
		= Integer.parseInt(request.getParameter("num1"));
		int num2 
		= Integer.parseInt(request.getParameter("num2"));
		
		PrintWriter out = response.getWriter();
		out.println(num1 + num2);
	}
	
}












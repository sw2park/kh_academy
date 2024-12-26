package com.kh.web.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class DoFrontController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		System.out.println("URI : " + request.getRequestURI());
		
		String requestURI = request.getRequestURI();
		String responseURI = null;
		
		if(requestURI.equals("/do1.do")) {
			responseURI = new Do1().execute(request, response);
//			request.setAttribute("result", "do1으로 요청보내기");
//			request.getRequestDispatcher("do1.jsp").forward(request, response);
		} else if(requestURI.equals("/do2.do")) {
			responseURI = new Do2().execute(request, response);
//			request.setAttribute("result", "do2으로 요청보내기");
//			request.getRequestDispatcher("do2.jsp").forward(request, response);
		} else if(requestURI.equals("/do3.do")) {
			responseURI = new Do3().execute(request, response);
//			request.setAttribute("result", "do3으로 요청보내기");
//			request.getRequestDispatcher("do3.jsp").forward(request, response);
		}
		request.getRequestDispatcher(responseURI).forward(request, response);
	}
}

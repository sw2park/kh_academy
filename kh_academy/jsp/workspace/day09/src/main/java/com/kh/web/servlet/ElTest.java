package com.kh.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class ElTest extends HttpServlet{
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		arg0.setAttribute("result", "success");
		
		String[] names = {"psw", "admin"};
		arg0.setAttribute("names", names);
		
		Map<String, Object> notice = new HashMap<>();
		notice.put("id", 1);
		notice.put("title", "el학습");
		arg0.setAttribute("notice", notice);
		
		RequestDispatcher dispatcher = arg0.getRequestDispatcher("/el/el_test3.jsp");
		dispatcher.forward(arg0, arg1);
	}
}
package com.kh.web.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Do1 {
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("result", "do1으로 요청보내기");
		return "do1.jsp";
	}
}

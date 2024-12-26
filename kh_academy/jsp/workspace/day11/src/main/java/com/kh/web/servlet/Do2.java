package com.kh.web.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Do2 {
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("result", "do2으로 요청보내기");
		return "do2.jsp";
	}
}

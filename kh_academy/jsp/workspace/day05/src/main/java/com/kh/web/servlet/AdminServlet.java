package com.kh.web.servlet;

import java.io.IOException;

import com.kh.web.dao.AdminDAO;
import com.kh.web.vo.AdminDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/join")
public class AdminServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		String username = request.getParameter("username");
		String userphone = request.getParameter("userphone");
		
		// data setting
		AdminDTO aDto = new AdminDTO();
		aDto.setUserid(userid);
		aDto.setUserpw(userpw);
		aDto.setUsername(username);
		aDto.setUserphone(userphone);
		
		AdminDAO aDao = new AdminDAO();
		boolean check = aDao.join(aDto);
		if(check){
			// 가입 성공 경우 이동할 페이지
		} else {
			// 가입 실패 경우 이동할 페이지
		}
	}
}

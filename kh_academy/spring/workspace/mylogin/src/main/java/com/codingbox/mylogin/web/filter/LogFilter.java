package com.codingbox.mylogin.web.filter;

import java.io.IOException;
import java.util.UUID;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class LogFilter implements Filter{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		String requestURI = httpRequest.getRequestURI();
		// 요청을 구분하기 위해서
		String uuid = UUID.randomUUID().toString();
		
		try {
			System.out.println("uuid : " + uuid);
			System.out.println("requestURI : " + requestURI);
			chain.doFilter(request, response);
		} catch (Exception e) {
			throw e;
		} finally {
			System.out.println("uuid : " + uuid);
			System.out.println("requestURI : " + requestURI);
		}
	}
}

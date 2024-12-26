package com.codingbox.mylogin.web.filter;

import java.io.IOException;

import org.springframework.util.PatternMatchUtils;

import com.codingbox.mylogin.web.session.SessionConst;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter{
	private static final String[] whitelist = {"/", "/members/add", "/login", "/logout", "/css/*"};
 	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
 		HttpServletRequest httpRequest = (HttpServletRequest)request;
 		String requestURI = httpRequest.getRequestURI();
 		
 		HttpServletResponse httpResponse = (HttpServletResponse)response;
 		
 		try {
 			System.out.println("인증 체크 필터 시작 : " + requestURI);
			
 			if(isLoginCheckPath(requestURI)) {		// whitelist에 없는 url이 if 조건문을 실행
 				System.out.println("인증 체크 로직 실행 : " + requestURI);
 				HttpSession session = httpRequest.getSession(false);
 				
 				if(session == null || session.getAttribute(SessionConst.LOGIN_MEMBER) == null) {
 					System.out.println("미인증 사용자가 요청 : " + requestURI);
 					// 로그인으로 redirect
 					// 즉, 내가 로그인 하지 않고 items페이지를
 					// 요청했다가 로그인이 되지않아서 튕김
 					httpResponse.sendRedirect("/login?redirectURL=" + requestURI);
 					return;
 				}
 			}
 			// 다음 필터로 넘어간다.
 			chain.doFilter(httpRequest, httpResponse);
		} catch (Exception e) {
			throw e;
		} finally {
			System.out.println("인증 체크 필터 종료 : " + requestURI);
		}
	}
 	
 	// 화이트 리스트인 경우 인증 체크 X
 	private boolean isLoginCheckPath(String requestURI) {
 		return !PatternMatchUtils.simpleMatch(whitelist, requestURI);
 	}
}
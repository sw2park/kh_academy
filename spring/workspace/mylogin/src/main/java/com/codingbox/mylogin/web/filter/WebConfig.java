package com.codingbox.mylogin.web.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterRegistration;

@Configuration
public class WebConfig {
	@Bean
	public FilterRegistrationBean logFilter() {
		FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
		
		// 내가 방금 만든 LogFilter를 넣어준다.
		filterRegistrationBean.setFilter(new LogFilter());
		filterRegistrationBean.setOrder(1);
		// 모든 url에 다 적용된다.
		filterRegistrationBean.addUrlPatterns("/*");
		
		return filterRegistrationBean;
	}
	@Bean
	public FilterRegistrationBean loginCheckFilter() {
		FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
		
		filterRegistrationBean.setFilter(new LoginCheckFilter());
		// 순서를 2번으로 잡았다. 로그 필터 다음에 로그인 필터가 적용
		filterRegistrationBean.setOrder(2);
		// 모든 요청에 로그인 필터를 적용한다. 어차피 LoginCheckFilter에서 걸러주기 때문
		filterRegistrationBean.addUrlPatterns("/*");
		
		return filterRegistrationBean;
	}
}
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
}
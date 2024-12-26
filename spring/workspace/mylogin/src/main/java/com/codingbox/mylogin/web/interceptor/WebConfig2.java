package com.codingbox.mylogin.web.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig2 implements WebMvcConfigurer{
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LogInterceptor())
				.order(1)
				.addPathPatterns("/**") // 모든 경로 전체가 인터셉터를 지났으면 좋겠다라는 뜻
				.excludePathPatterns("/css/**", "/*.ico", "/error"); // 이 경우만 제외
		
		registry.addInterceptor(new LoginCheckInterceptor())
				.order(2)
				.addPathPatterns("/**")
				.excludePathPatterns("/", "/members/add", "/login", "/logout", "/css/**");
	}
}
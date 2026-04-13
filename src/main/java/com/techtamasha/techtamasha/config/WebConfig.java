package com.techtamasha.techtamasha.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Autowired
	private SessionInterceptor sessionInterceptor;
	
	List<String> list = List.of("/employee/login","/employee/register","/employee/saveEmployee","/employee/loginEmployee");

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(sessionInterceptor)
		.addPathPatterns("/**")
		.excludePathPatterns(list);
		
	}
	
}

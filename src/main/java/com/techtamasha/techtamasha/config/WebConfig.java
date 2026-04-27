package com.techtamasha.techtamasha.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Autowired
	private SessionInterceptor sessionInterceptor;
	
	
	List<String> list = List.of("/", "/submit",
			"/employee/login",
			"/employee/showEmp",
			"/employee/showImage",
			"/employee/register",
			"/employee/saveEmployee",
			"/employee/loginEmployee",
			"/user/register",
			"/user/website",
			"/user/login",
			"/user/registerUser",
			"/user/loginUser",
			"/email/**",
			"/employee/index");

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(sessionInterceptor)
		.addPathPatterns("/**")
		.excludePathPatterns(list);
		
	}
	
	
	
}

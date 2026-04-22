package com.techtamasha.techtamasha.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SessionInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {		

		if(request.getSession().getAttribute("user") == null) {
			response.sendRedirect("/user/login");
			return false;
		}		
		
		
		
		return true;
		
	}
	
	// register this interceptor in config class : WebConfig.java
	
	
	

}

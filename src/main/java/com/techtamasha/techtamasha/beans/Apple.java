package com.techtamasha.techtamasha.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // bean create krna 
//@Scope("singleton")
@Scope("prototype")
public class Apple {

	public void eat() {
		System.out.println("I m eating apple");
	}
	
//	@PostConstruct
//	public void initializedBean() {
//		System.out.println("starts server....");
//	}
//	
//	@PreDestroy
//	public void afterDestroy() {
//		System.out.println("close all the resources..");
//	}
	
	

}

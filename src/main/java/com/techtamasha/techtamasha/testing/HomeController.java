package com.techtamasha.techtamasha.testing;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

	// method : return type String :
	
	@GetMapping("/open")
	public String testing() {
		return "home";
	}
	
	@GetMapping("/home2")
	public String homeOpening() {
		return "home2";
	}
	
}

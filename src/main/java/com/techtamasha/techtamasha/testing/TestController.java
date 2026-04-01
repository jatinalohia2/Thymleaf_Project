package com.techtamasha.techtamasha.testing;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // end points for testing purpose
@RequestMapping("/testing")
public class TestController {
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}

}

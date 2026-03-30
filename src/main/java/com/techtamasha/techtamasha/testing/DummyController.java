package com.techtamasha.techtamasha.testing;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dummy")
public class DummyController {
	
	@GetMapping("/open")
	public String testing(Model model) {
		model.addAttribute("name", "Jatin");
		model.addAttribute("age", 20);
		model.addAttribute("items" , List.of("A" , "B" , "C"));
		return "home3";
	}
	
	@GetMapping("/open1")
	public String testing1(Model model) {
		return "home";
	}

}

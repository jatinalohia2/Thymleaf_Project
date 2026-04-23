package com.techtamasha.techtamasha.advisw;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.techtamasha.techtamasha.shopping.entity.User;

import jakarta.servlet.http.HttpSession;

@ControllerAdvice
public class Centralized {

	@ModelAttribute
	public void showAllData(HttpSession session, Model model) {
		User currentUser = (User) session.getAttribute("user");
		model.addAttribute("currentUser", currentUser);
	}

}

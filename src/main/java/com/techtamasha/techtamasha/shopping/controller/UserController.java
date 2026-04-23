package com.techtamasha.techtamasha.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techtamasha.techtamasha.shopping.entity.User;
import com.techtamasha.techtamasha.shopping.enums.UserCategory;
import com.techtamasha.techtamasha.shopping.service.ProductCategoryService;
import com.techtamasha.techtamasha.shopping.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductCategoryService productCategoryService;

	@GetMapping("/register")
	public String user(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "shopping/user-form";
	}

	@PostMapping("/registerUser")
	public String saveEmployee(User user, RedirectAttributes attr) {
		userService.save(user);
		attr.addFlashAttribute("success", "User Register Successfully");
		return "redirect:/user/login";
	}

	@GetMapping("/login")
	public String employeeLogin(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "shopping/login";
	}

	@PostMapping("/loginUser")
	public String login(User user, RedirectAttributes attr, HttpSession session) {

		User user2 = userService.checkLogin(user.getEmail(), user.getPassword());

		if (user2 != null) {
			attr.addFlashAttribute("success", "User login successful");
			session.setAttribute("user", user2); // employee2 -> id , name , email , password

			if (user2.getUserCategory() == UserCategory.ADMIN) {
				return "redirect:/user/dashboard";
			} else {
				return "redirect:/user/website";
			}

		} else {
			System.out.println("Login failed");
			attr.addFlashAttribute("warning", "Invalid email or password");
			return "redirect:/user/login";
		}
	}
	

	// dashboard :
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, RedirectAttributes attr, Model model) {
		return "ui/dashboard";
	}

	// dashboard :
	@GetMapping("/website")
	public String website(HttpSession session, RedirectAttributes attr, Model model) {
		model.addAttribute("categoryList", productCategoryService.findAll());
		return "shopping/website";
	}

	// logout:
	@GetMapping("/logout")
	public String logout(HttpSession session, RedirectAttributes attr) {
		session.removeAttribute("user");
		attr.addFlashAttribute("success", "Employee logged out successfully");
		return "redirect:/user/login";
	}

	@GetMapping("/showAllCustomer")
	public String showAllCustomer(HttpSession session, RedirectAttributes attr, Model model) {
		
		List<User> customers = userService.findByUserCategory(UserCategory.CUSTOMER);
		model.addAttribute("customers", customers);
		
		return "shopping/show-all-customer";
	}

}

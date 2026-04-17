package com.techtamasha.techtamasha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techtamasha.techtamasha.entity.Employee;
import com.techtamasha.techtamasha.repository.EmployeeRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/register")
	public String employeeHome(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "ui/employee-form";
	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(Employee employee) {
		employeeRepository.save(employee);
		return "redirect:/employee/register";
	}

	// login :
	@GetMapping("/login")
	public String employeeLogin(Model model) {

		Employee employee = new Employee();

		model.addAttribute("employee", employee);

		return "ui/login";
	}

	@PostMapping("/loginEmployee")
	public String login(Employee employee, RedirectAttributes attr, HttpSession session) {

		System.out.println(employee.getEmail() + " " + employee.getPassword());

		// r@gmail , 123
		Employee employee2 = employeeRepository.checkLogin(employee.getEmail(), employee.getPassword());

		if (employee2 != null) {
			System.out.println("Login successful");
			attr.addFlashAttribute("success", "Employee login successful");
			// session management :

			session.setAttribute("emp", employee2); // employee2 -> id , name , email , password

			return "redirect:/employee/dashboard";

		} else {
			System.out.println("Login failed");
			attr.addFlashAttribute("warning", "Invalid email or password");
			return "redirect:/employee/login";

		}

	}

	// dashboard :
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, RedirectAttributes attr, Model model) {
		System.out.println("dashboard called");
		return "ui/dashboard";
	}

	// logout:
	@GetMapping("/logout")
	public String logout(HttpSession session, RedirectAttributes attr) {
		session.removeAttribute("emp");
		attr.addFlashAttribute("success", "Employee logged out successfully");
		return "redirect:/employee/login";
	}

	
	@GetMapping("/users")
	public String users(HttpSession session, RedirectAttributes attr) {
		
		return "users";
	}
	
	@GetMapping("/index")
	public String index(HttpSession session, RedirectAttributes attr) {
		return "index";
	}

}

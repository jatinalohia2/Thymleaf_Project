package com.techtamasha.techtamasha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techtamasha.techtamasha.entity.Student;
import com.techtamasha.techtamasha.repository.StudentRepository;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentRepository studentRepository;

//	public void saveStudent() {
//		Student student = new Student(null, "jatin", "bca", 12, 90, "hello", "hii");
//		studentRepository.save(student); // insert into .....
//		Student student1 = new Student(1, "jatin", "bca", 12, 90, "hello", "hii");
//		studentRepository.delete(student1); 
//
//	}
	
	@GetMapping
	public String studentPage(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "student-form";
	}

	@PostMapping("/saveStudent")
	public String student(
	        @Valid @ModelAttribute("student") Student student,
	        BindingResult result,
	        Model model) {

	    if (result.hasErrors()) {
	        System.out.println("validation error");
	        return "student-form";
	    }

	    studentRepository.save(student);
	    return "redirect:/student";
	}

	// ------------------------------------------

	@GetMapping("/show")
	public String showAllStudents(Model model , HttpSession session ,
			@RequestParam(required = false) String query) {
		
		System.out.println("query : " + query);
		
		if(query != null) {
			List<Student> students = studentRepository.findByNameLike(query);
			model.addAttribute("studentList", students);
			return "ui/show-all-student";
		}

		List<Student> students = studentRepository.findAll(); // select * from student
		model.addAttribute("studentList", students);
		return "ui/show-all-student";
	}

	@GetMapping("/delete")
	public String delete(Integer id) {
		System.out.println("id comes : " + id);
		studentRepository.deleteById(id); // delete from student where id = ?;
		return "redirect:/student/show";
	}

	// update :
	@GetMapping("/edit")
	public String edit(Integer id, Model model) { // findById
		Student student = studentRepository.findById(id).orElse(null); // select * from student where id = ?;
		model.addAttribute("student", student);
		return "student-form";
	}
	
	

}

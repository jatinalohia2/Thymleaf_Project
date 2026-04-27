package com.techtamasha.techtamasha.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techtamasha.techtamasha.entity.Employee;

@Controller
@RequestMapping("/email")
public class EmailController {

	@Autowired
	private JavaMailSender javaMailSender;

	@GetMapping("/send")
	public String sendEmail(Model model) {
		// 1. Turn on 2FA :  app password generate :  abcd hjhj hjhg ihjh
		// 2. configuration :
		// 3. send email -> (JavaMailSender)
		return "email";
	}
	
	
	@PostMapping("/sendEmail")
	public String sendEmail1(@RequestParam String email , @RequestParam String msg) {
		
		System.out.println(email   + " : "+msg);
		
		// send email :
		
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setText(msg);
		simpleMailMessage.setFrom("sahibpreetsingh432@gmail.com");
		simpleMailMessage.setTo(email);
		simpleMailMessage.setSubject("Applicant for java developer");
		simpleMailMessage.setSentDate(new Date());
		
		javaMailSender.send(simpleMailMessage);
		
		return "redirect:/email/send";
	}
	
	
	
}

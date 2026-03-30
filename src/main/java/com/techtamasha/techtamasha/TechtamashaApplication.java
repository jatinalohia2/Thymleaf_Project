package com.techtamasha.techtamasha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.techtamasha.techtamasha.beans.Apple;
import com.techtamasha.techtamasha.controller.StudentController;
import com.techtamasha.techtamasha.entity.Student;
import com.techtamasha.techtamasha.repository.StudentRepository;
import com.techtamasha.techtamasha.testing.Kiwi;

@SpringBootApplication // starting point.
public class TechtamashaApplication implements CommandLineRunner {

	@Autowired
	Apple apple1;

	@Autowired
	Apple apple2;

	@Autowired
	Apple apple3;

	@Autowired
	Kiwi kiwi;

	@Autowired
	StudentController studentController;

	@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(TechtamashaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		Student student = new Student(1, "jatin", "bca", 12, 90, "hello", "hii");
//		studentRepository.save(student);
//
//		studentController.saveStudent();

	}
}

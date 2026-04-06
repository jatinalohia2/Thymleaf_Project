package com.techtamasha.techtamasha;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.techtamasha.techtamasha.entity.Student;
import com.techtamasha.techtamasha.repository.StudentRepository;

@SpringBootTest
class TechtamashaApplicationTests {

	@Autowired
	StudentRepository studentRepository;

	@Test
	void contextLoads() {

		Optional<Student> optional = studentRepository.findById(702);
		if (optional.isPresent()) {
			Student student = optional.get();
			System.out.println("get : " + student);
		} else {
			System.out.println("student not found");
		}

		Student student = studentRepository.findByAge(15);

		System.out.println("student : " + student);

		Optional<Student> byCourse = Optional.empty();
		if (byCourse.isPresent()) {
			Student student2 = byCourse.get();
			System.out.println("student2 : " + student2);
		} else {
			System.out.println("student not found");
		}

		Student student2 = studentRepository.findByFatherName("Neve Bridges");
		System.out.println("student3 : " + student2);

		Student nameAndCourse = studentRepository.findByNameAndCourse("Ora ", "Pariatur Assumenda ");

		System.out.println("nameAndCourse : " + nameAndCourse);

		studentRepository.deleteById(702);
		studentRepository.deleteByAge(702);

	}

}

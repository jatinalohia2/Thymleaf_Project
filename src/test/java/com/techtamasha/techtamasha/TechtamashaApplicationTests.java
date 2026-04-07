package com.techtamasha.techtamasha;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.techtamasha.techtamasha.entity.Student;
import com.techtamasha.techtamasha.entity.StudentIdentityCard;
import com.techtamasha.techtamasha.repository.StudentIdentityCardRepository;
import com.techtamasha.techtamasha.repository.StudentRepository;

@SpringBootTest
class TechtamashaApplicationTests {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	StudentIdentityCardRepository cardRepository;
	
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
	
	
	@Test
	public void studentOperation() {
		
		Student student = new Student();
		student.setAge(12);
		student.setCourse("mca");
		student.setPhn(12345);
		student.setName("aman");
		
		Student student2 = studentRepository.save(student);
		
		
		StudentIdentityCard card = new StudentIdentityCard();
		card.setCardNo("ABC123");
		card.setStudent(student2);
		
		cardRepository.save(card);
		
		// we cannot add multiple student inside student_iden_card -> one to one 
		
//		StudentIdentityCard card1 = new StudentIdentityCard();
//		card1.setCardNo("ABC123");
//		card1.setStudent(student2);
//		
//		cardRepository.save(card1);
		
	}
	
	
	@Test
	public void getStudentById() {
		Optional<Student> optional = studentRepository.findById(52);
		
		if (optional.isPresent()) {
			
			Student student = optional.get();
			
			System.out.println("stduent : "+student);
			
			StudentIdentityCard studentIdentityCard = student.getStudentIdentityCard();
			
			System.out.println("studentIdentityCard : "+studentIdentityCard.getCardNo());
			
			Optional<StudentIdentityCard> byId = cardRepository.findById(2L);
			
			if (byId.isPresent()) {
				
				StudentIdentityCard studentIdentityCard2 = byId.get();
				
				Student student2 = studentIdentityCard2.getStudent();
				
				System.out.println(student2.getName());
				
			}
			
		}
		
	}
	
	
	
	
	
	
	

}

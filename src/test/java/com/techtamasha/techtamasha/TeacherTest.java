package com.techtamasha.techtamasha;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.techtamasha.techtamasha.entity.Stud;
import com.techtamasha.techtamasha.entity.Teacher;
import com.techtamasha.techtamasha.repository.StudRepository;
import com.techtamasha.techtamasha.repository.TeacherRepo;

@SpringBootTest
public class TeacherTest {

	@Autowired
	private TeacherRepo teacherRepo;
	
	@Autowired
	private StudRepository studRepository;

	@Test
	public void saveTeacherWithStudent() {

//		Teacher teacher = new Teacher();
//		teacher.setName("Jatin");
//
//		Stud s1 = new Stud();
//		s1.setName("gurleen");
//
//		Stud s2 = new Stud();
//		s2.setName("priy");
//
//		s1.setTeacher(teacher);
//		s2.setTeacher(teacher);
//
//		teacher.setStuds(List.of(s1, s2)); // student wale table m entry 2
//		teacherRepo.save(teacher);
//
//		Optional<Teacher> byId = teacherRepo.findById(1L);
//
//		if (byId.isPresent()) {
//
//			Teacher teacher1 = byId.get();
//			teacher1.setName("Anju Mam");
//			teacherRepo.save(teacher1); // save and update:
//		}
		
		
		// GET TEACHER :
		
		Optional<Teacher> optionalTeacher = teacherRepo.findById(1L);
		
		if (optionalTeacher.isPresent()) {
			
			Teacher teacher = optionalTeacher.get();
			
			System.out.println(teacher);
						
//			List<Stud> studs = teacher.getStuds(); // query join
//			System.out.println(studs);
			
			List<Stud> students = studRepository.findByTeacher(teacher.getId());
			System.out.println(students);
			
			
		}

	}
}

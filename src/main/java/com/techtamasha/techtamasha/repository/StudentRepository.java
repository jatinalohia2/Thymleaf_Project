package com.techtamasha.techtamasha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.techtamasha.techtamasha.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

	@Query("select s from Student s where s.age = :i")
	Student findByAge(int i);

	@Query("select s from Student s where s.course = :c")
	List<Student> findByCourse(String c);

	// hibernate will create query for you : 
//	select * from student where father_name = "Neve Bridges"
	
	Student findByFatherName(String string);
	
	Student findByMotherName(String name);
	
	// hibernate will create query for you :
	// 
	Student findByNameAndCourse(String n, String c);

	
	void deleteByAge(int i);	
	
	List<Student> findByName(String n);
	
	// like operator : jpa method :
	
	@Query("select s from Student s where s.name like %:n%")
	List<Student> findByNameLike(String n);
	
	
}

package com.techtamasha.techtamasha.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techtamasha.techtamasha.entity.Teacher;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long> {

	
	
}
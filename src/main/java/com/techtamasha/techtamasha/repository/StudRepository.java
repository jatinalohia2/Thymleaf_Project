package com.techtamasha.techtamasha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.techtamasha.techtamasha.entity.Stud;

@Repository
public interface StudRepository extends JpaRepository<Stud, Long>{

	@Query("select u from Stud u where u.teacher.id = :id")
	List<Stud> findByTeacher(Long id);
	
	
	
}

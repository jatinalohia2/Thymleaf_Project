package com.techtamasha.techtamasha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techtamasha.techtamasha.entity.StudentIdentityCard;

@Repository
public interface StudentIdentityCardRepository extends JpaRepository<StudentIdentityCard, Long>{


	
}

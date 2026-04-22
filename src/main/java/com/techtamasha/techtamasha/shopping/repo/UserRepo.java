package com.techtamasha.techtamasha.shopping.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.techtamasha.techtamasha.shopping.entity.User;

public interface UserRepo extends JpaRepository<User, Long>{

	@Query("SELECT e FROM User e WHERE e.email = :e AND e.password = :p")
	User checkLogin(String e, String p);
	
}

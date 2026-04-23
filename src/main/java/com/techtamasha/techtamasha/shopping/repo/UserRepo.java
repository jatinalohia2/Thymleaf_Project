package com.techtamasha.techtamasha.shopping.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.techtamasha.techtamasha.shopping.entity.User;
import com.techtamasha.techtamasha.shopping.enums.UserCategory;

public interface UserRepo extends JpaRepository<User, Long> {

	@Query("SELECT e FROM User e WHERE e.email = :e AND e.password = :p")
	User checkLogin(String e, String p);

	@Query("SELECT e FROM User e WHERE e.userCategory = :customer")
	List<User> findByUserCategory(UserCategory customer);

}

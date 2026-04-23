package com.techtamasha.techtamasha.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techtamasha.techtamasha.shopping.entity.User;
import com.techtamasha.techtamasha.shopping.enums.UserCategory;
import com.techtamasha.techtamasha.shopping.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	public void save(User user) {
		user.setUserCategory(UserCategory.CUSTOMER);
		userRepo.save(user);
	}

	public User checkLogin(String email, String password) {
		return userRepo.checkLogin(email , password);
	}

	public List<User> findByUserCategory(UserCategory customer) {
		return userRepo.findByUserCategory(customer);
	} 
}

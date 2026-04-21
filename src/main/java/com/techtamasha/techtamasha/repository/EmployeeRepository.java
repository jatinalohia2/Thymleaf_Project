package com.techtamasha.techtamasha.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.techtamasha.techtamasha.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query("SELECT e FROM Employee e WHERE e.email = :e AND e.password = :p")
	Employee checkLogin(String e, String p);
	
	
	
	
	
}
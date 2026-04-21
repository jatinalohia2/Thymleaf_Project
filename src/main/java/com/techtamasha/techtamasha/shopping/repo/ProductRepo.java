package com.techtamasha.techtamasha.shopping.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techtamasha.techtamasha.shopping.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Long>{

	
	List<Product> findByProductCategoryId(Long catId);

}

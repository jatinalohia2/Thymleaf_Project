package com.techtamasha.techtamasha.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techtamasha.techtamasha.shopping.entity.Product;
import com.techtamasha.techtamasha.shopping.repo.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	public void saveProduct(Product product) {
		productRepo.save(product);
	}

	public List<Product> findByProductCategoryId(Long catId) {
		return productRepo.findByProductCategoryId(catId);
	}

	public List<Product> findAll() {
		return productRepo.findAll();
	}

}

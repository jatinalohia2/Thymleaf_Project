package com.techtamasha.techtamasha.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techtamasha.techtamasha.shopping.entity.ProductCategory;
import com.techtamasha.techtamasha.shopping.repo.ProductCategoryRepo;

@Service
public class ProductCategoryService {

	@Autowired
	private ProductCategoryRepo productCategoryRepo;
	
	public void save(ProductCategory productCategory) {
		productCategoryRepo.save(productCategory);
	}

	public List<ProductCategory> findAll() {
		return productCategoryRepo.findAll();
	}
}

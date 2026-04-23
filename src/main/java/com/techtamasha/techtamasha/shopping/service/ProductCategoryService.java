package com.techtamasha.techtamasha.shopping.service;

import java.io.IOException;
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
		
		try {
		
			byte[] bytes = productCategory.getFile().getBytes();
			productCategory.setImage(bytes);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		productCategoryRepo.save(productCategory);
	}

	public List<ProductCategory> findAll() {
		return productCategoryRepo.findAll();
	}

	public void deleteById(Long id) {
		productCategoryRepo.deleteById(id);
	}

	public ProductCategory findById(Long id) {
		return productCategoryRepo.findById(id).orElse(null);
	}
}

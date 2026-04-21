package com.techtamasha.techtamasha.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techtamasha.techtamasha.shopping.entity.ProductCategory;
import com.techtamasha.techtamasha.shopping.service.ProductCategoryService;

@Controller
@RequestMapping("/category")
public class ProductCategoryController {
	
	@Autowired
	private ProductCategoryService productCategoryService;

	@GetMapping
	public String productCategoryForm(Model model) {
		ProductCategory productCategory = new ProductCategory();
		model.addAttribute("productCategory", productCategory);
		return "shopping/product-category";
	}
	
	@PostMapping("/saveProductCategory")
	public String saveCategory(@ModelAttribute ProductCategory productCategory , RedirectAttributes attributes) {
		System.out.println(productCategory);
		productCategoryService.save(productCategory);
		attributes.addFlashAttribute("success", "Category Successfully Added");
		return "redirect:/category";
	}
}

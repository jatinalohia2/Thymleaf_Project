package com.techtamasha.techtamasha.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techtamasha.techtamasha.shopping.entity.Product;
import com.techtamasha.techtamasha.shopping.entity.ProductCategory;
import com.techtamasha.techtamasha.shopping.service.ProductCategoryService;
import com.techtamasha.techtamasha.shopping.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductCategoryService productCategoryService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public String productCategoryForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);

		List<ProductCategory> categoryList = productCategoryService.findAll();
		model.addAttribute("categoryList" , categoryList);
		return "shopping/product";
	}

	@PostMapping("/save")
	public String saveCategory(@ModelAttribute Product product, RedirectAttributes attributes) {
		productService.saveProduct(product);
		attributes.addFlashAttribute("success", "Product Successfully Added");
		return "redirect:/product";
	}
	
	@GetMapping("/showAllProduct")
	public String showAll(Model model) {
		List<ProductCategory> categoryList = productCategoryService.findAll();
		model.addAttribute("categoryList" , categoryList);
		return "shopping/show-all-product";
	}
	
	@GetMapping("/productCategoryWise")
	public String showAll(@RequestParam("id") Long catId , Model model) {
		
		List<Product> listProduct = productService.findByProductCategoryId(catId);
		model.addAttribute("listProduct" , listProduct);

		return "shopping/show-all-product2";
	}
	
	
}

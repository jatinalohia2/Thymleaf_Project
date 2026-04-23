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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techtamasha.techtamasha.entity.Employee;
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
		// list
		
		List<ProductCategory> categoryList = productCategoryService.findAll();
		model.addAttribute("categoryList", categoryList);
		
		return "shopping/product-category";
	}
	
	@PostMapping("/saveProductCategory")
	public String saveCategory(@ModelAttribute ProductCategory productCategory , RedirectAttributes attributes) {
		System.out.println(productCategory);
		productCategoryService.save(productCategory);
		attributes.addFlashAttribute("success", "Category Successfully Added");
		return "redirect:/category";
	}
	
	@GetMapping("/delete")
	public String productCategoryForm(@RequestParam Long id ,RedirectAttributes attributes) {

		productCategoryService.deleteById(id);
		attributes.addFlashAttribute("warning", "Category Successfully Deleted");
		return "redirect:/category";
	}
	
	@GetMapping("/showImage")
	@ResponseBody
	public byte[] showImages(@RequestParam Long id) {
		ProductCategory productCategory= productCategoryService.findById(id);
		return productCategory.getImage();
	}
}

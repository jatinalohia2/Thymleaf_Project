package com.techtamasha.techtamasha;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.techtamasha.techtamasha.entity.Employee;
import com.techtamasha.techtamasha.entity.Product;
import com.techtamasha.techtamasha.entity.Project;
import com.techtamasha.techtamasha.entity.Purchase;
import com.techtamasha.techtamasha.repository.EmployeeRepository;
import com.techtamasha.techtamasha.repository.ProductRepository;
import com.techtamasha.techtamasha.repository.ProjectRepository;
import com.techtamasha.techtamasha.repository.PurchaseRepository;

@SpringBootTest
public class TestingPurpose {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private PurchaseRepository purchaseRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Test
	public void saveProduct() {
		
		Purchase purchase = new Purchase();
		purchase.setInvoiceNumber("INV-001");
		purchase.setTotalAmount("100");
		
		Purchase savePurchase = purchaseRepository.save(purchase);
		
		
		Product product = new Product();
		product.setProductName("Product 1");
		product.setPrice("50");
		
		product.setPurchase(savePurchase);
		
		
		Product product1 = new Product();
		product1.setProductName("Product 2");
		product1.setPrice("30");
		
		product1.setPurchase(savePurchase);
		
		
		Product product2 = new Product();
		product2.setProductName("Product 3");
		product2.setPrice("20");
		
		product2.setPurchase(savePurchase);
		
		
		List<Product> products = new ArrayList<>();
		products.add(product);
		products.add(product1);
		products.add(product2);
		
		productRepository.saveAll(products);
	}
	
	@Test
	public void showPurchase() {
		
		Purchase purchase = purchaseRepository.findById(1L).orElse(null);
		
		if(purchase != null) {
			System.out.println("Invoice Number : " + purchase.getInvoiceNumber());
			System.out.println("Total Amount : " + purchase.getTotalAmount());
			
			
			List<Product> products = productRepository.findByPurchase(purchase.getId());
			
			
			for(Product product : products) {
				System.out.println("Product Name : " + product.getProductName());
				System.out.println("Price : " + product.getPrice());
			}
		} else {
			System.out.println("Purchase not found");
		}
		
	}
	
	
	@Test
	public void saveProject() {
	
		Project p1 = new Project();
		p1.setProjectName("Banking App");
		
		Project p2 = new Project();
		p2.setProjectName("Finanace App");
		
		Project save1 = projectRepository.save(p1);
		Project save2 = projectRepository.save(p2);
		
		
		//-------------------------------------
		
		Employee e1 = new Employee();
		e1.setName("John Doe");
		
		// --assign project to employee
		
		e1.setProjects(List.of(save1, save2));
		
		employeeRepository.save(e1);
		
		
		
		
		
	}
	
	
	
}

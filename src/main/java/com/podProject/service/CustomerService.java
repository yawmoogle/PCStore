package com.podProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.podProject.model.Product;
import com.podProject.repository.CustomerRepo;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepo customerRepo;
	
	// display all products with price
	public List<Product> displayAllProducts() {
		return customerRepo.findAll();
	}

	public boolean saveEntry(Product product) {
		// TODO Auto-generated method stub
		customerRepo.save(new Product(product.getProductName(), product.getProductPrice()));
		return true;
	}

	public List<Product> getAllProducts() {
		return customerRepo.findAll();
	}

}

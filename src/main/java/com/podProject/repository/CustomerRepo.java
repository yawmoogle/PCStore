package com.podProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.podProject.model.Product;

@Repository
public interface CustomerRepo extends JpaRepository<Product, Long> {

	@Query("SELECT productName FROM Product")
	List<Product> listProducts();
	
	@Query("SELECT productPrice FROM Product")
	List<Product> listProductPrice();
	
}

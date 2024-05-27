package com.podProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

import com.podProject.model.Product;
import com.podProject.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customerProductPage")
	public String goToCustomerProdPage(Model model) {
		model.addAttribute("product", customerService.displayAllProducts());
		return "customerProductPage";
	}
	
	@GetMapping("/tempAddProd")
	public String goToAddProd() {
		return "tempAddProd";
	}
	
	@PostMapping("addProducts")
	public String addProd(Product product) {
		customerService.saveEntry(product);
		return "redirect:tempAddProd";
	}

}

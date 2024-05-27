package com.podProject.controller;

import java.util.List;

import com.podProject.model.AdminProduct;
import com.podProject.model.Product;
import com.podProject.service.AdminProductService;
import com.podProject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
public class AdminProductController {
	
	@Autowired
    private AdminProductService adminProductService;

    @GetMapping("/products")
    public String showAdminProducts(Model model) {
        List<AdminProduct> adminProducts = adminProductService.getAllAdminProducts();
        model.addAttribute("adminProduct", adminProducts);
        return "adminProducts";
    }

}

package com.podProject.service;

import com.podProject.model.AdminProduct;
import com.podProject.repository.AdminProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminProductService {

    @Autowired
    private final AdminProductRepository adminProductRepository;

    public AdminProductService(AdminProductRepository adminProductRepository) {
        this.adminProductRepository = adminProductRepository;
    }

    public List<AdminProduct> getAllAdminProducts() {
        return this.adminProductRepository.findAll();
    }

    public void saveAdminProduct(AdminProduct adminProduct) {
        this.adminProductRepository.save(adminProduct);
    }
}

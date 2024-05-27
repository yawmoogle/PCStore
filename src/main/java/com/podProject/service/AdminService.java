package com.podProject.service;

import com.podProject.model.Admin;
import com.podProject.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AdminService(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createAdmin(Admin admin) {
        // Encrypt the password before saving
        String encodedPassword = passwordEncoder.encode(admin.getAdminpassword());
        admin.setAdminpassword(encodedPassword);
        adminRepository.save(admin);
    }
    public boolean existsByAdminusername(String username) {
        return adminRepository.existsByAdminusername(username);
    }
}
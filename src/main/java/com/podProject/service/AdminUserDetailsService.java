package com.podProject.service;

import com.podProject.model.Admin;
import com.podProject.model.AuthAdmin;
import com.podProject.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminUserDetailsService implements UserDetailsService {

    private final AdminRepository adminRepository;
    @Autowired
    public AdminUserDetailsService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;

    }
//    private final PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public AdminUserDetailsService(AdminRepository adminRepository, @Lazy PasswordEncoder passwordEncoder) {
//        this.adminRepository = adminRepository;
//        this.passwordEncoder = passwordEncoder;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Admin> adminOptional = adminRepository.findByAdminusername(username);
        Admin admin = adminOptional.orElseThrow(() ->
                new UsernameNotFoundException("No admin found with username: " + username)
        );

        // Return an instance of AuthAdmin, which implements UserDetails
        return new AuthAdmin(admin);
    }

}

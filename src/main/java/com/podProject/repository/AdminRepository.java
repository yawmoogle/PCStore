package com.podProject.repository;

import com.podProject.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByAdminusername(String adminusername);
    boolean existsByAdminusername(String adminusername);
}

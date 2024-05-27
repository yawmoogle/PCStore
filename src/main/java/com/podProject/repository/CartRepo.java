package com.podProject.repository;

import com.podProject.model.Cart;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {
    
}

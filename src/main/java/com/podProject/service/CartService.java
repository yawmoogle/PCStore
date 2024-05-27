package com.podProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.podProject.repository.CartRepo;

@Service
public class CartService {
    @Autowired
    private CartRepo cartRepo;
}

package com.podProject.controller;

import com.podProject.service.CartService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/cart")
public class CartController {
    private static final Logger logger =  LogManager.getLogger(ComponentController.class);

    @Autowired
    private CartService cartService;

    @GetMapping("/cart")
    public String goToCart() {
        return "/cart";
    }
    


}

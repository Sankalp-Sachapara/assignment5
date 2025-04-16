package com.cestar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple controller to test if the application is running correctly
 */
@RestController
public class HomeController {
    
    public HomeController() {
        System.out.println("HomeController initialized!");
    }
    
    @GetMapping("/")
    public String home() {
        return "Library API is running!";
    }
    
    @GetMapping("/test")
    public String test() {
        return "Test endpoint working!";
    }
}

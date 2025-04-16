package com.cestar.Assignment5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.cestar.config.AppConfig;
import com.cestar.config.WebConfig;

@SpringBootApplication
@ComponentScan(basePackages = {"com.cestar.controller", "com.cestar.dao", "com.cestar.model"})
@EntityScan("com.cestar.model")
@Import({AppConfig.class, WebConfig.class})
public class LibraryApp {
    public static void main(String[] args) {
        System.out.println("Starting Online Library Application...");
        try {
            new SpringApplicationBuilder(LibraryApp.class)
                .properties("server.port=8080") // Updated to use port 8080
                .properties("logging.level.root=DEBUG") 
                .properties("logging.level.com.cestar=DEBUG") 
                .properties("logging.level.org.springframework.web=DEBUG") // Added web specific logging
                .properties("spring.main.allow-bean-definition-overriding=true") // Allow bean overriding
                .run(args);
            System.out.println("Application started successfully on port 8080!");
            System.out.println("Try accessing these endpoints:");
            System.out.println("- http://localhost:8080/ (Home test endpoint)");
            System.out.println("- http://localhost:8080/test (Test endpoint)");
            System.out.println("- http://localhost:8080/api/books (List all books)");
            System.out.println("- http://localhost:8080/api/books/check (Book controller test)");
        } catch (Exception e) {
            System.err.println("Failed to start application:");
            e.printStackTrace();
        }
    }
}
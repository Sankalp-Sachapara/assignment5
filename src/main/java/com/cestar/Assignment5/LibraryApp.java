package com.cestar.Assignment5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;

import com.cestar.config.AppConfig;
import com.cestar.config.WebConfig;

@SpringBootApplication(scanBasePackages = "com.cestar")
@Import({AppConfig.class, WebConfig.class})
public class LibraryApp {
    public static void main(String[] args) {
        System.out.println("Starting Online Library Application...");
        try {
            new SpringApplicationBuilder(LibraryApp.class)
                .properties("server.port=8088") // Set port here
                .properties("logging.level.root=DEBUG") // Add debug logging
                .properties("logging.level.com.cestar=DEBUG") // More specific logging
                .properties("logging.level.org.springframework=INFO") // Spring framework logging
                .run(args);
            System.out.println("Application started successfully on port 8088!");
        } catch (Exception e) {
            System.err.println("Failed to start application:");
            e.printStackTrace();
        }
    }
}
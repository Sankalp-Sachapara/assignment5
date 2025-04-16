package com.cestar.Assignment5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;

import com.cestar.config.AppConfig;
import com.cestar.config.WebConfig;

@SpringBootApplication
@Import({AppConfig.class, WebConfig.class})
public class LibraryApp {
    public static void main(String[] args) {
        new SpringApplicationBuilder(LibraryApp.class)
            .properties("server.port=8088") // Set port here
            .run(args);
    }
}
package com.cestar.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.cestar")
public class WebConfig implements WebMvcConfigurer {
    // Configure web-specific components here
    // No need for application.properties with this configuration
}
package com.cestar.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class AppConfig {
    
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        
        // Add connection parameters for better reliability
        String url = "jdbc:mysql://localhost:3306/OnlineLibrary" + 
                     "?useSSL=false" +
                     "&allowPublicKeyRetrieval=true" +
                     "&serverTimezone=UTC" +
                     "&createDatabaseIfNotExist=true";
        
        dataSource.setUrl(url);
        dataSource.setUsername("root");
        dataSource.setPassword("");
        
        System.out.println("Configuring MySQL data source with URL: " + url);
        return dataSource;
    }
    
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        // Add this to check connection at startup
        try {
            System.out.println("Testing database connection...");
            String result = template.queryForObject("SELECT 'Database connection successful' as test", String.class);
            System.out.println(result);
        } catch (Exception e) {
            System.err.println("Database connection failed: " + e.getMessage());
            e.printStackTrace();
        }
        return template;
    }
}
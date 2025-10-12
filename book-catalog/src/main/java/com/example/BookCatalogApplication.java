package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for the Book Catalog.
 */
@SpringBootApplication
public class BookCatalogApplication {
    /**
     * Starts the Spring Boot application.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(BookCatalogApplication.class, args);
    }
}
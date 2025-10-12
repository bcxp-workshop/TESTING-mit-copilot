package com.example;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Application configuration: Register ModelMapper as a Spring Bean.
 */
@Configuration
public class AppConfig {
    /**
     * Provides ModelMapper as a Bean for dependency injection.
     *
     * @return ModelMapper instance
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
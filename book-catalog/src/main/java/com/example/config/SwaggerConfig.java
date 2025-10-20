package com.example.config;

import io.swagger.v3.oas.models.servers.Server;
import java.util.List;
import org.springdoc.api.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenApiCustomiser serverOpenApiCustomizer() {
        return openApi -> openApi.setServers(List.of(new Server().url("")));
    }
}
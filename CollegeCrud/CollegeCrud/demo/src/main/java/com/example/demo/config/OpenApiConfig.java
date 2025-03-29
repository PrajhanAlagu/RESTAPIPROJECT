package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        Server localServer = new Server()
            .url("http://localhost:8081")
            .description("Local Development Server");

        return new OpenAPI()
            .info(new Info()
                .title("College CRUD API")
                .description("RESTful API for College Management System")
                .version("1.0")
                .contact(new Contact()
                    .name("College Admin")
                    .email("admin@college.com")
                    .url("https://www.college.com"))
                .license(new License()
                    .name("Apache 2.0")
                    .url("http://www.apache.org/licenses/LICENSE-2.0.html")))
            .servers(List.of(localServer));
    }
}
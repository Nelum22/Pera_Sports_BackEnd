package com.example.pera_sport_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.example.pera_sport_app.Entity")
@EnableJpaRepositories(basePackages = "com.example.pera_sport_app.repository")
public class PeraSportAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(PeraSportAppApplication.class, args);
    }
}

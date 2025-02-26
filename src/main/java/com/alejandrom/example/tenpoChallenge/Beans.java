package com.alejandrom.example.tenpoChallenge;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class Beans {

    @Bean
    public ExecutorService executor() {
        return Executors.newFixedThreadPool(10);
    }
}

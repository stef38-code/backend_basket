package com.stephane.backend.basketball;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.stephane.backend.basketball"})
public class BackendBasketballApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendBasketballApplication.class, args);
    }
}




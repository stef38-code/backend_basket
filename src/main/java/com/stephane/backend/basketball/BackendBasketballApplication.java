package com.stephane.backend.basketball;

import com.stephane.backend.basketball.entities.Genre;
import com.stephane.backend.basketball.entities.Personne;
import com.stephane.backend.basketball.entities.Role;
import com.stephane.backend.basketball.repository.PersonneRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;

@SpringBootApplication
public class BackendBasketballApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendBasketballApplication.class, args);
    }
}




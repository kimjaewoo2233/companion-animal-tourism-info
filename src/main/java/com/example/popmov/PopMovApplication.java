package com.example.popmov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PopMovApplication {

    public static void main(String[] args) {
        SpringApplication.run(PopMovApplication.class, args);
    }

}

package com.lance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author youth
 */
@SpringBootApplication
@EnableScheduling
public class EnglishApplication {

    public static void main (String[] args) {
        SpringApplication.run(EnglishApplication.class, args);
    }

}

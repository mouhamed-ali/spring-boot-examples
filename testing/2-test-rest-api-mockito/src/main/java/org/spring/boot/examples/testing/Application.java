package org.spring.boot.examples.testing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"org.spring.boot.examples.entities"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
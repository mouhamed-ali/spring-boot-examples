package org.spring.boot.examples.web.rest.swagger.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SwaggerApplication {

    public static void main(String[] args) {

        SpringApplication.run(SwaggerApplication.class, args);
    }

    /*
     * the generated documentation : http://localhost:8080/swagger-ui.html
     * the generated swagger : http://localhost:8080/v2/api-docs
     */
}

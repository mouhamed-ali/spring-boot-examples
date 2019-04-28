package org.spring.boot.examples.web.rest.producer.oauth2;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Oauth2Application {

    public static void main(String[] args) {

        SpringApplication.run(Oauth2Application.class, args);

        /*
         * source : https://dzone.com/articles/securing-rest-services-with-oauth2-in-springboot-1
         *
         * To test the app : check the postman collection in the test resources.
         */
    }
}

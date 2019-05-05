package org.spring.boot.examples.http.ssl;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        // close the application context to shut down the custom ExecutorService
        SpringApplication.run(Application.class, args).close();

        /*
         * source : https://nakov.com/blog/2009/07/16/disable-certificate-validation-in-java-ssl-connections/
         */
    }
}

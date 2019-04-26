package org.spring.boot.examples.rest.consumer.ssl;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SSLApplication {

    public static void main(String[] args) {

        // close the application context to shut down the custom ExecutorService
        SpringApplication.run(SSLApplication.class, args).close();
    }
}

package org.spring.boot.examples.rest.consumer.ssl.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppRunner.class);
    private final RestTemplate restTemplate;

    public AppRunner(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void run(String... args) throws Exception {


        ResponseEntity<String> response = restTemplate.getForEntity("http://dummy.restapiexample.com/api/v1/employees", String.class);
        LOGGER.info("Server response : {}", response.getBody());
    }
}

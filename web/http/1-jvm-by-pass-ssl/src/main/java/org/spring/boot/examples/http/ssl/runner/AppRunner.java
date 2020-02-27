package org.spring.boot.examples.http.ssl.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.boot.examples.http.ssl.utils.SSLUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppRunner.class);
    private final RestTemplate restTemplate;
    private final SSLUtils sslUtils;

    public AppRunner(RestTemplate restTemplate, SSLUtils sslUtils) {
        this.restTemplate = restTemplate;
        this.sslUtils = sslUtils;
    }

    public void run(String... args) throws Exception {

        LOGGER.info("ssl verification status : {}", sslUtils.isSslVerificationEnabled());
        ResponseEntity<String> response = restTemplate.getForEntity("https://apiv3.iucnredlist.org/api/v3/version", String.class);
        LOGGER.info("Server response : {}", response.getBody());
    }
}

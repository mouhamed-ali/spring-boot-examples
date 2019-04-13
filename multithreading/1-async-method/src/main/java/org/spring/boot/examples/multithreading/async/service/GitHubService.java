package org.spring.boot.examples.multithreading.async.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.boot.examples.multithreading.async.entity.User;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
/*
 * The class is marked with the @Service annotation, making it a candidate for Spring’s component scanning to detect
 * it and add it to the application context.
 */
public class GitHubService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GitHubService.class);

    private final RestTemplate restTemplate;

    public GitHubService(RestTemplateBuilder restTemplateBuilder) {

        /*
         * Spring Boot automatically provides a RestTemplateBuilder that customizes the defaults with any
         * auto-configuration bits (i.e. MessageConverter)
         */
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    /*
     * The findUser method is flagged with Spring’s @Async annotation, indicating it will run on a separate thread.
     */
    public CompletableFuture<User> findUser(String user) throws InterruptedException {

        /*
         * The method’s return type is CompletableFuture<User> instead of User, a requirement for any asynchronous service.
         * This code uses the completedFuture method to return a CompletableFuture instance which is already completed with
         * result of the GitHub query.
         */
        LOGGER.info("Looking up " + user);
        String url = String.format("https://api.github.com/users/%s", user);
        User results = restTemplate.getForObject(url, User.class);
        // Artificial delay of 1s for demonstration purposes
        Thread.sleep(1000L);
        return CompletableFuture.completedFuture(results);
    }
}

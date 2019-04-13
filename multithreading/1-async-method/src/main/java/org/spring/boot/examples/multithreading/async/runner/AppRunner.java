package org.spring.boot.examples.multithreading.async.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.boot.examples.multithreading.async.entity.User;
import org.spring.boot.examples.multithreading.async.service.GitHubService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppRunner.class);

    private final GitHubService gitHubService;

    public AppRunner(GitHubService gitHubLookupService) {
        this.gitHubService = gitHubLookupService;
    }

    /*
     * CommandLineRunner is a simple Spring Boot interface with a run method.
     * Spring Boot will automatically call the run method of all beans implementing this interface after
     * the application context has been loaded.
     */
    @Override
    public void run(String... args) throws Exception {
        // Start the clock
        long start = System.currentTimeMillis();

        // Kick of multiple, asynchronous lookups
        CompletableFuture<User> page1 = gitHubService.findUser("PivotalSoftware");
        CompletableFuture<User> page2 = gitHubService.findUser("CloudFoundry");
        CompletableFuture<User> page3 = gitHubService.findUser("Spring-Projects");

        // Wait until they are all done
        CompletableFuture.allOf(page1, page2, page3).join();

        // Print results, including elapsed time
        LOGGER.info("Elapsed time: " + (System.currentTimeMillis() - start));
        LOGGER.info("--> " + page1.get());
        LOGGER.info("--> " + page2.get());
        LOGGER.info("--> " + page3.get());

    }
}

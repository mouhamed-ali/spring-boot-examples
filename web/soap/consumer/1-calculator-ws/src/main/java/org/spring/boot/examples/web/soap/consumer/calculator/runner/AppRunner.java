package org.spring.boot.examples.web.soap.consumer.calculator.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.boot.examples.web.soap.consumer.calculator.service.AddService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppRunner.class);
    private final AddService addService;

    public AppRunner(AddService addService) {
        this.addService = addService;
    }

    public void run(String... args) throws Exception {

        LOGGER.info("{}", addService.add(1, 2));
    }
}

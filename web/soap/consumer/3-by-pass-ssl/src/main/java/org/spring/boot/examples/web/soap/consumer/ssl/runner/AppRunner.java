package org.spring.boot.examples.web.soap.consumer.ssl.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.boot.examples.web.soap.consumer.ssl.service.CheckCreditsService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppRunner.class);
    private final CheckCreditsService checkCreditsService;

    public AppRunner(CheckCreditsService checkCreditsService) {
        this.checkCreditsService = checkCreditsService;
    }


    public void run(String... args) throws Exception {

        LOGGER.info("the result of the ws call is : {}", checkCreditsService.checkDummyCredit());
    }
}

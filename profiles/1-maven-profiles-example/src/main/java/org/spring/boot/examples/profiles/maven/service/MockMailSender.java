package org.spring.boot.examples.profiles.maven.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MockMailSender implements MailSender {

    /*
     * this logger can be used in sub classes (with inheritance)
     */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void send(String to, String object, String message) {

        logger.info("Sending a MOCK mail ...");
        logger.info("to : {} , object : {}", to, object);
        logger.info("message : {}", message);
        logger.info("operation terminated successfully.");
    }
}

package org.spring.boot.examples.packaging.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Service("mockSender")
public class MockMessageSender implements MessageSender {


    private static final Logger LOGGER = LoggerFactory.getLogger(MockMessageSender.class);

    @Override
    public void send(String to, String message) throws UnknownHostException {

        LOGGER.info("### Start sending a mock message ...");
        LOGGER.info("### From : {}", InetAddress.getLocalHost());
        LOGGER.info("### To : {}", to);
        LOGGER.info("### Message : {}", message);
        LOGGER.info("### method ended successfully");
    }
}

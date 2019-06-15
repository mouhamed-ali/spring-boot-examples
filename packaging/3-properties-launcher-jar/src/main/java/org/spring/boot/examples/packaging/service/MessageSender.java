package org.spring.boot.examples.packaging.service;

public interface MessageSender {

    void send(String to, String message) throws Exception;
}

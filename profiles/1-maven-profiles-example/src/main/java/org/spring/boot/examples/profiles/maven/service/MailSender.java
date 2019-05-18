package org.spring.boot.examples.profiles.maven.service;

public interface MailSender {

    void send(String to, String object, String message);
}

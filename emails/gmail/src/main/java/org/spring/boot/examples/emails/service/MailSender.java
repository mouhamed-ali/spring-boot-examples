package org.spring.boot.examples.emails.service;

public interface MailSender {

    void sendSimpleMessage(String to, String subject, String text);
}

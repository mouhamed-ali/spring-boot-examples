package org.spring.boot.examples.emails.service;

import com.sendgrid.Response;

import java.io.IOException;

public interface MailSender {

    Response sendSimpleMessage(String from, String to, String subject, String text) throws IOException;
}

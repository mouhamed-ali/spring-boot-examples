package org.spring.boot.examples.emails.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class GmailSender implements MailSender {

    private final JavaMailSender emailSender;

    public GmailSender(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }


    public void sendSimpleMessage(String to, String subject, String text) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }
}

package org.spring.boot.examples.profiles.maven.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
/*
 * you can use this annotation instead of @Configuration but it's a bad practise
 */
public class MailServerConfig {

    @Value("${email.server}")
    private String emailServer;

    public String getEmailServer() {
        return emailServer;
    }

    public MailServerConfig setEmailServer(String emailServer) {
        this.emailServer = emailServer;
        return this;
    }

    @Override
    public String toString() {
        return "MailServerConfig{" +
                "emailServer='" + emailServer + '\'' +
                '}';
    }
}

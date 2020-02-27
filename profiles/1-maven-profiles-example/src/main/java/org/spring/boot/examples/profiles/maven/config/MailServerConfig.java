package org.spring.boot.examples.profiles.maven.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
/*
 * you can use this annotation instead of @Configuration but it's a bad practise
 * actually, the difference is : when using @Configuration + you declare some beans with @Bean annotation this beans will be cached.
 * assume that you have this method [ @Bean demoBean(){ return new DemoBean();} ]. if you call this method many times in a @Configuration class you will
 * have the same object but if you call it in a @Component class you will have a new object every time you call the method.
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

package org.spring.boot.examples.web.soap.consumer.book.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientProperties {

    @Value("${client.default-uri}")
    private String defaultUri;

    @Value("${client.user.name}")
    private String userName;

    @Value("${client.user.password}")
    private String password;

    public String getDefaultUri() {
        return this.defaultUri;
    }

    public ClientProperties setDefaultUri(String defaultUri) {
        this.defaultUri = defaultUri;
        return this;
    }

    public String getUserName() {
        return this.userName;
    }

    public ClientProperties setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return this.password;
    }

    public ClientProperties setPassword(String password) {
        this.password = password;
        return this;
    }
}

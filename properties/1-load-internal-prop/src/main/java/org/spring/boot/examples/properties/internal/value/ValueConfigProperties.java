package org.spring.boot.examples.properties.internal.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValueConfigProperties {

    @Value("${database.url}")
    private String url;

    @Value("${database.username}")
    private String userName;

    @Value("${database.password}")
    private String password;

    @Value("${secret}")
    private String secret;

    @Value("${datasource.notFound:404}")
    private String notFound;//the value will be 404 if the property does not exist

    public String getUrl() {
        return url;
    }

    public ValueConfigProperties setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public ValueConfigProperties setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public ValueConfigProperties setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getSecret() {
        return secret;
    }

    public ValueConfigProperties setSecret(String secret) {
        this.secret = secret;
        return this;
    }

    public String getNotFound() {
        return notFound;
    }

    public ValueConfigProperties setNotFound(String notFound) {
        this.notFound = notFound;
        return this;
    }
}

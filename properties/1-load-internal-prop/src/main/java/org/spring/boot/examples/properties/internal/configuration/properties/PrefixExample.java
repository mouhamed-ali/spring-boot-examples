package org.spring.boot.examples.properties.internal.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "database")
public class PrefixExample {

    private String url;
    private String userName; //this matches username or user-name or userName
    private String password;

    public String getUrl() {
        return url;
    }

    public PrefixExample setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public PrefixExample setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public PrefixExample setPassword(String password) {
        this.password = password;
        return this;
    }
}

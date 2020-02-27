package org.spring.boot.examples.packaging.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "db")
public class DataBaseConfig {

    private String url;
    private String user;
    private String password;

    public String getUrl() {
        return url;
    }

    public DataBaseConfig setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getUser() {
        return user;
    }

    public DataBaseConfig setUser(String user) {
        this.user = user;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public DataBaseConfig setPassword(String password) {
        this.password = password;
        return this;
    }
}

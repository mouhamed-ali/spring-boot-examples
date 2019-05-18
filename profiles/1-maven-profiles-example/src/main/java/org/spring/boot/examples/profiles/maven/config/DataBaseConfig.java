package org.spring.boot.examples.profiles.maven.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config.properties")
@ConfigurationProperties(prefix = "db")
public class DataBaseConfig {

    private String url;
    private String username;
    private String driverClassName;
    private String password;

    public String getUrl() {
        return url;
    }

    public DataBaseConfig setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public DataBaseConfig setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public DataBaseConfig setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public DataBaseConfig setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return "\nDataBaseConfig{ \n" +
                "url='" + url + '\'' + "\n" +
                "username='" + username + '\'' + "\n" +
                "driverClassName='" + driverClassName + '\'' + "\n" +
                "password='" + password + '\'' + "\n" +
                '}';
    }
}

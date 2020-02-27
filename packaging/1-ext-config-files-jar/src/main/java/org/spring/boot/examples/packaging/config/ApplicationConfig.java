package org.spring.boot.examples.packaging.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
public class ApplicationConfig {

    private String currentPlatform;
    private String currentUser;

    public String getCurrentPlatform() {
        return currentPlatform;
    }

    public ApplicationConfig setCurrentPlatform(String currentPlatform) {
        this.currentPlatform = currentPlatform;
        return this;
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public ApplicationConfig setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
        return this;
    }

    @Override
    public String toString() {
        return "ApplicationConfig{" +
                "currentPlatform='" + currentPlatform + '\'' +
                ", currentUser='" + currentUser + '\'' +
                '}';
    }
}

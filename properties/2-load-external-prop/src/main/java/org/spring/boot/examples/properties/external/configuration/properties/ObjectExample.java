package org.spring.boot.examples.properties.external.configuration.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "object")
@PropertySource("file:${APP_HOME}/object.properties")
public class ObjectExample {

    private Credentials credentials;

    public Credentials getCredentials() {
        return credentials;
    }

    public ObjectExample setCredentials(Credentials credentials) {
        this.credentials = credentials;
        return this;
    }
}

class Credentials {

    private String userName;
    private String password;
    private String authMethod;

    public String getUserName() {
        return userName;
    }

    public Credentials setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Credentials setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getAuthMethod() {
        return authMethod;
    }

    public Credentials setAuthMethod(String authMethod) {
        this.authMethod = authMethod;
        return this;
    }

    @Override
    public String toString() {
        return "Credentials{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", authMethod='" + authMethod + '\'' +
                '}';
    }
}

package org.spring.boot.examples.properties.internal.env;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class EnvConfigProperties implements InitializingBean {

    private final Environment environment;
    private String url;
    private String userName;
    private String password;
    private String secret;

    public EnvConfigProperties(Environment environment) {
        this.environment = environment;
    }

    public String getUrl() {
        return url;
    }

    public EnvConfigProperties setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public EnvConfigProperties setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public EnvConfigProperties setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getSecret() {
        return secret;
    }

    public EnvConfigProperties setSecret(String secret) {
        this.secret = secret;
        return this;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        setUrl(environment.getProperty("database.url"));
        setUserName(environment.getProperty("database.username"));
        setPassword(environment.getProperty("database.password"));
        setSecret(environment.getProperty("secret"));
    }
}

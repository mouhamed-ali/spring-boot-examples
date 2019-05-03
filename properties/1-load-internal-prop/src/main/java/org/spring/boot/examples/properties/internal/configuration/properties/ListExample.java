package org.spring.boot.examples.properties.internal.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "list")
public class ListExample {

    private List<String> users;

    public List<String> getUsers() {
        return users;
    }

    public ListExample setUsers(List<String> users) {
        this.users = users;
        return this;
    }
}

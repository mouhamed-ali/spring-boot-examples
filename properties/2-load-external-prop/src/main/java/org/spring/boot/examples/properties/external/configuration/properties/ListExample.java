package org.spring.boot.examples.properties.external.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "list")
@PropertySource("file:${APP_HOME}/list.properties")
public class ListExample {

    private List<String> users;

    public List<String> getUsers() {
        return users;
    }

    public ListExample setUsers(List<String> users) {
        this.users = users;
        return this;
    }

    @Override
    public String toString() {
        return "ListExample{" +
                "users=" + users +
                '}';
    }
}

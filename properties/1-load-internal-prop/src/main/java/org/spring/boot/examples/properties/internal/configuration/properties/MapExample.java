package org.spring.boot.examples.properties.internal.configuration.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "map")
public class MapExample {

    private Map<String, String> administrators;

    public Map<String, String> getAdministrators() {
        return administrators;
    }

    public MapExample setAdministrators(Map<String, String> administrators) {
        this.administrators = administrators;
        return this;
    }
}

package org.spring.boot.examples.properties.external.configuration.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "map")
@PropertySource("file:${APP_HOME}/map.properties")
public class MapExample {

    private Map<String, String> administrators;

    public Map<String, String> getAdministrators() {
        return administrators;
    }

    public MapExample setAdministrators(Map<String, String> administrators) {
        this.administrators = administrators;
        return this;
    }

    @Override
    public String toString() {
        return "MapExample{" +
                "administrators=" + administrators +
                '}';
    }
}

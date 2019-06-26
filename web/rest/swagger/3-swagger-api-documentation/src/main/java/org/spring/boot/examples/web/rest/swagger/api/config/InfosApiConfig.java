package org.spring.boot.examples.web.rest.swagger.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app")
public class InfosApiConfig {

    private String name;
    private String description;
    private String version;

    public String getName() {
        return name;
    }

    public InfosApiConfig setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public InfosApiConfig setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public InfosApiConfig setVersion(String version) {
        this.version = version;
        return this;
    }
}

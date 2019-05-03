package org.spring.boot.examples.properties.internal.property.source;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:mail.yml")
@ConfigurationProperties(prefix = "mail")
public class Example {

    private String hostName;
    private Integer port;
    private String from;

    public String getHostName() {
        return hostName;
    }

    public Example setHostName(String hostName) {
        this.hostName = hostName;
        return this;
    }

    public Integer getPort() {
        return port;
    }

    public Example setPort(Integer port) {
        this.port = port;
        return this;
    }

    public String getFrom() {
        return from;
    }

    public Example setFrom(String from) {
        this.from = from;
        return this;
    }
}

package org.spring.boot.examples.properties.internal.property.source;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:mail.properties")
/*
 * please note that you can't load yaml files using @PropertySource. only .properties files check this for details :
 * https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-external-config-yaml-shortcomings
 */
@ConfigurationProperties(prefix = "mail")
public class PropertySourceExample {

    private String hostName;//this will loads host-name, hostname, hostName
    private Integer port;
    private String from;

    public String getHostName() {
        return hostName;
    }

    public PropertySourceExample setHostName(String hostName) {
        this.hostName = hostName;
        return this;
    }

    public Integer getPort() {
        return port;
    }

    public PropertySourceExample setPort(Integer port) {
        this.port = port;
        return this;
    }

    public String getFrom() {
        return from;
    }

    public PropertySourceExample setFrom(String from) {
        this.from = from;
        return this;
    }
}

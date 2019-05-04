package org.spring.boot.examples.properties.external.property.source;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        @PropertySource(value = "file:${APP_HOME}/database.properties", ignoreResourceNotFound = true),
        //spring will not throw an exception if he doesn't find this file

        @PropertySource("file:${APP_HOME}/mail.properties")
})
public class PropertySourceNotFoundExample {

    @Value("${database.url:not_found_url}")
    private String url;

    @Value("${mail.from}")
    private String from;

    public String getUrl() {
        return url;
    }

    public PropertySourceNotFoundExample setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getFrom() {
        return from;
    }

    public PropertySourceNotFoundExample setFrom(String from) {
        this.from = from;
        return this;
    }

    @Override
    public String toString() {
        return "PropertySourceNotFoundExample{" +
                "url='" + url + '\'' +
                ", from='" + from + '\'' +
                '}';
    }
}

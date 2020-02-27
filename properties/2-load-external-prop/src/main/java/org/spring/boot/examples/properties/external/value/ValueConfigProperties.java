package org.spring.boot.examples.properties.external.value;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("file:${APP_HOME}/config.properties")
public class ValueConfigProperties {

    @Value("${application.name}")
    private String name;

    @Value("${author}")
    private String author;

    public String getName() {
        return name;
    }

    public ValueConfigProperties setName(String name) {
        this.name = name;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public ValueConfigProperties setAuthor(String author) {
        this.author = author;
        return this;
    }

    @Override
    public String toString() {
        return "ValueConfigProperties{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

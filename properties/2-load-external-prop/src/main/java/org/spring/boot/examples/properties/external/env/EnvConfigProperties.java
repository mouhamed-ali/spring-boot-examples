package org.spring.boot.examples.properties.external.env;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("file:${APP_HOME}/config.properties")
public class EnvConfigProperties implements InitializingBean {

    private final Environment environment;
    private String version;
    private String name;
    private String date;

    public EnvConfigProperties(Environment environment) {
        this.environment = environment;
    }

    public String getVersion() {
        return version;
    }

    public EnvConfigProperties setVersion(String version) {
        this.version = version;
        return this;
    }

    public String getName() {
        return name;
    }

    public EnvConfigProperties setName(String name) {
        this.name = name;
        return this;
    }

    public String getDate() {
        return date;
    }

    public EnvConfigProperties setDate(String date) {
        this.date = date;
        return this;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        setVersion(environment.getProperty("application.version"));
        setName(environment.getProperty("application.name"));
        setDate(environment.getProperty("application.date"));
    }

    @Override
    public String toString() {
        return "EnvConfigProperties{" +
                "version='" + version + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}

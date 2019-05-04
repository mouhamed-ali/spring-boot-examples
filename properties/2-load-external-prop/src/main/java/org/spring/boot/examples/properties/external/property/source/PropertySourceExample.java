package org.spring.boot.examples.properties.external.property.source;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({
        "file:${APP_HOME}/config.properties",
        "file:${APP_HOME}/mail.properties"
})
public class PropertySourceExample {

    @Value("${application.version}")
    private String version;

    @Value("${mail.host-name}")
    private String hostName;

    public String getVersion() {
        return version;
    }

    public PropertySourceExample setVersion(String version) {
        this.version = version;
        return this;
    }

    public String getHostName() {
        return hostName;
    }

    public PropertySourceExample setHostName(String hostName) {
        this.hostName = hostName;
        return this;
    }

    @Override
    public String toString() {
        return "PropertySourceExample{" +
                "version='" + version + '\'' +
                ", hostName='" + hostName + '\'' +
                '}';
    }
}

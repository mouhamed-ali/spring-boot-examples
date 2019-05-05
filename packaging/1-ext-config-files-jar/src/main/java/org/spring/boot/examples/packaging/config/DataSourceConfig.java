package org.spring.boot.examples.packaging.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "datasource")
public class DataSourceConfig {

    private String url;
    private String userName;
    private String password;
    private String platform;
    private Integer port;

    public String getUrl() {
        return url;
    }

    public DataSourceConfig setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public DataSourceConfig setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public DataSourceConfig setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPlatform() {
        return platform;
    }

    public DataSourceConfig setPlatform(String platform) {
        this.platform = platform;
        return this;
    }

    public Integer getPort() {
        return port;
    }

    public DataSourceConfig setPort(Integer port) {
        this.port = port;
        return this;
    }

    @Override
    public String toString() {
        return "DataSourceConfig{" +
                "url='" + url + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", platform='" + platform + '\'' +
                ", port=" + port +
                '}';
    }
}

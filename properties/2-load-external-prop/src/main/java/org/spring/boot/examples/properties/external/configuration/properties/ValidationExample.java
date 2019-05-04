package org.spring.boot.examples.properties.external.configuration.properties;

import org.hibernate.validator.constraints.Length;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Configuration
@ConfigurationProperties
@PropertySource("file:${APP_HOME}/db.properties")
@Validated
public class ValidationExample {

    @NotBlank
    @Length(max = 15, min = 2)
    private String dialect;

    @Email(message = "please type a valid email")
    private String email;

    @Max(8090)
    @Min(8070)
    private Integer port;

    public String getDialect() {
        return dialect;
    }

    public ValidationExample setDialect(String dialect) {
        this.dialect = dialect;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ValidationExample setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getPort() {
        return port;
    }

    public ValidationExample setPort(Integer port) {
        this.port = port;
        return this;
    }

    @Override
    public String toString() {
        return "ValidationExample{" +
                "dialect='" + dialect + '\'' +
                ", email='" + email + '\'' +
                ", port=" + port +
                '}';
    }
}

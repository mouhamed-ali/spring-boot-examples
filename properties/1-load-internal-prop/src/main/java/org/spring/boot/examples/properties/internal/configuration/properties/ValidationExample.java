package org.spring.boot.examples.properties.internal.configuration.properties;

import org.hibernate.validator.constraints.Length;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Configuration
@ConfigurationProperties
@Validated
public class ValidationExample {

    @NotBlank
    @Pattern(regexp = "^[0-9]+[a-z]$")//starts by a number and ends by a lowercase letter
    @Length(max = 4, min = 1)
    private String secret;

    @Max(8090)
    @Min(8070)
    private Integer port;

    public String getSecret() {
        return secret;
    }

    public ValidationExample setSecret(String secret) {
        this.secret = secret;
        return this;
    }

    public Integer getPort() {
        return port;
    }

    public ValidationExample setPort(Integer port) {
        this.port = port;
        return this;
    }
}

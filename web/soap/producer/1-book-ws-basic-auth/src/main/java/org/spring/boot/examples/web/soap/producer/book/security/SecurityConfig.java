package org.spring.boot.examples.web.soap.producer.book.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /*
     * we must disable the crsf protection otherwise we must manage the spring security crsf token in all our
     * requests
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http
                .csrf()
                .disable();
    }
}

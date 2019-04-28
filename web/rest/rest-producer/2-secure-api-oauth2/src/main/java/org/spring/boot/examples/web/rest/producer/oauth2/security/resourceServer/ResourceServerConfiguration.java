package org.spring.boot.examples.web.rest.producer.oauth2.security.resourceServer;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@EnableResourceServer
/*
 * @EnableResourceServerannotation will cause Spring to activate the resource server.
 */
@Configuration
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {


    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/oauth/token", "/oauth/authorize**", "/public")
                .permitAll()

                .antMatchers("/private").hasAnyRole("USER")

                .antMatchers("/admin").access("hasRole('ADMIN')")

                .anyRequest().denyAll();
    }
}

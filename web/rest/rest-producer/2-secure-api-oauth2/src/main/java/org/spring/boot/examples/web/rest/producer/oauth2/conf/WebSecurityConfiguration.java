package org.spring.boot.examples.web.rest.producer.oauth2.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    @Override
    public UserDetailsService userDetailsService() {

        UserDetails user = User.builder().username("user").password(passwordEncoder.encode("user_password")).
                roles("USER").build();

        UserDetails userAdmin = User.builder().username("admin").password(passwordEncoder.encode("admin_password")).
                roles("ADMIN").build();

        return new InMemoryUserDetailsManager(user, userAdmin);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {

        return super.authenticationManagerBean();
    }
}

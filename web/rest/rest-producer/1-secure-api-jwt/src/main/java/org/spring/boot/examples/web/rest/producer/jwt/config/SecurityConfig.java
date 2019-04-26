package org.spring.boot.examples.web.rest.producer.jwt.config;

import org.spring.boot.examples.web.rest.producer.jwt.repository.UserCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
/*
 * The architecture of Spring Security is based entirely on Servlet Filters.
 * The simplest option to register our Spring security filter is by annotating our config class with @EnableWebSecurity
 * This is the primary spring security annotation that is used to enable web security in a project.
 */
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /*
     * Our SecurityConfig class extends WebSecurityConfigurerAdapter and overrides some of its methods to provide custom security configurations.
     */

    @Autowired
    private UserCrudService userCrudService;

    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

        /*
         * AuthenticationManagerBuilder is used to create an AuthenticationManager instance which is
         * the main Spring Security interface for authenticating a user.
         * You can use AuthenticationManagerBuilder to build in-memory authentication, LDAP authentication, JDBC authentication,
         * or add your custom authentication provider.
         */
        /*
         * Prior to Spring Security 5.0 the default PasswordEncoder was NoOpPasswordEncoder which required plain text passwords.
         * In Spring Security 5, the default is DelegatingPasswordEncoder, which required Password Storage Format.
         * Add password storage format, for plain text, add {noop}
         * Source : https://www.mkyong.com/spring-boot/spring-security-there-is-no-passwordencoder-mapped-for-the-id-null/
         */
        User user = userCrudService.findByUsername("user").get();
        auth.inMemoryAuthentication()
                .withUser(user.getUsername()).password("{noop}" + user.getPassword()).roles("USER");
        // i'm using only one user just to make the example simple otherwise you can retrieve you users from a database
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /*
         * The HttpSecurity configurations are used to configure security functionalities like csrf, sessionManagement, and add rules to protect
         * resources based on various conditions.
         */
        http
                .cors()
                .and()
                .csrf()
                .disable()
                .exceptionHandling()
                .authenticationEntryPoint(unauthorizedHandler)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/auth/**")
                .permitAll()
                .anyRequest()
                .authenticated();

        // Add our custom JWT security filter
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);


    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }
}

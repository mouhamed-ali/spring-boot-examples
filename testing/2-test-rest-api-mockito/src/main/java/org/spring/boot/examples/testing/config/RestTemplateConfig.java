package org.spring.boot.examples.testing.config;

import org.spring.boot.examples.testing.config.interceptors.HttpRequestInterceptor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * this rest template will be used to get users from the github api
 */
@Configuration
public class RestTemplateConfig {


    @Bean
    @Profile("production")
    public RestTemplate restTemplateProduction(RestTemplateBuilder builder) {

        return builder.build();
    }

    @Bean
    @Profile({"development", "test"})    //you can user this annotation if you want @Profile("!production")
    public RestTemplate restTemplateDevelopment() {

        /*
               create an Http interceptor to trace all the requests of our rest template
         */
        RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new HttpRequestInterceptor());
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }
}

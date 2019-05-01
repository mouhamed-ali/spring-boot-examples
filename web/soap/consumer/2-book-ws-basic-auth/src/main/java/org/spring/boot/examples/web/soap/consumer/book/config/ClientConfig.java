package org.spring.boot.examples.web.soap.consumer.book.config;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

@Configuration
public class ClientConfig {

    @Autowired
    private ClientProperties clientProperties;

    public ClientConfig() {
    }

    @Bean
    Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setContextPath("com.extservice.book");
        return jaxb2Marshaller;
    }

    @Bean
    public WebServiceTemplate webServiceTemplate() {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setMarshaller(this.jaxb2Marshaller());
        webServiceTemplate.setUnmarshaller(this.jaxb2Marshaller());
        webServiceTemplate.setDefaultUri(this.clientProperties.getDefaultUri());
        webServiceTemplate.setMessageSender(httpComponentsMessageSender());
        return webServiceTemplate;
    }

    public HttpComponentsMessageSender httpComponentsMessageSender() {
        HttpComponentsMessageSender httpComponentsMessageSender = new HttpComponentsMessageSender();
        httpComponentsMessageSender.setCredentials(this.usernamePasswordCredentials());
        return httpComponentsMessageSender;
    }

    public UsernamePasswordCredentials usernamePasswordCredentials() {
        return new UsernamePasswordCredentials(this.clientProperties.getUserName(), this.clientProperties.getPassword());
    }
}

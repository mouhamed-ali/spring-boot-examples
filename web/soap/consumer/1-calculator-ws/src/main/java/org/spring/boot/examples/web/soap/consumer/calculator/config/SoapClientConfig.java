package org.spring.boot.examples.web.soap.consumer.calculator.config;

import org.spring.boot.examples.web.soap.consumer.calculator.interceptors.CustomEndpointInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;

@Configuration
public class SoapClientConfig {

    @Bean
    public WebServiceTemplate webServiceTemplate() {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setMarshaller(jaxb2Marshaller());
        webServiceTemplate.setUnmarshaller(jaxb2Marshaller());
        webServiceTemplate.setDefaultUri("http://www.dneonline.com/calculator.asmx");

        //Now we gonna add a soap request/response interceptor. it's gonna be helpful for debugging
        //use it only on the dev platform
        ClientInterceptor[] interceptors = {new CustomEndpointInterceptor()};
        webServiceTemplate.setInterceptors(interceptors);

        return webServiceTemplate;
    }

    public Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in plugin section. see pom.xml
        marshaller.setContextPath("org.spring.boot.examples.web.soap.consumer.calculator.generated");
        return marshaller;
    }
}

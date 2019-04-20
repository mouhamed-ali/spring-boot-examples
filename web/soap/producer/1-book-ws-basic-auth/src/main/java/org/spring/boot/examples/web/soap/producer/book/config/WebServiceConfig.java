package org.spring.boot.examples.web.soap.producer.book.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;

import javax.servlet.Servlet;

@EnableWs
/*
 * To enable the support for the @Endpoint annotation we need to annotate our configuration class with @EnableWs
 */
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    /*
     * source : https://codenotfound.com/spring-ws-example.html
     * The server-side of Spring-WS is designed around a central class called MessageDispatcher that dispatches incoming XML messages to endpoints.
     * Spring Web Services supports multiple transport protocols. The most common is the HTTP transport, for which a custom MessageDispatcherServlet servlet is supplied.
     * The MessageDispatcherServlet is used to handle xml messages over http
     *
     * In the below WebServiceConfig configuration class we use a ServletRegistrationBean to register the MessageDispatcherServlet.
     *
     * The servlet mapping URI pattern on the ServletRegistrationBean is set to “/ws/book/*”. The web container will use this path to map incoming HTTP requests to the servlet.
     */
    @Bean
    public ServletRegistrationBean<Servlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        return new ServletRegistrationBean<>(servlet, "/ws/library/*");
    }

    /*
     * The DefaultWsdl11Definition exposes a standard WSDL 1.1 using the specified Book WSDL file.
     * The URL location at which this WSDL is available is determined by it’s Bean name in combination with the URI mapping of the MessageDispatcherServlet.
     * [host]="http://localhost:8080"+[servlet mapping uri]=”/ws/library/”+[WsdlDefinition bean name]=”books”+[WSDL postfix]=”.wsdl”.
     * in our case it will be :
     * http://localhost:8080/ws/library/books.wsdl
     */
    @Bean(name = "books")
    public Wsdl11Definition defaultWsdl11Definition() {
        SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
        /*
         * if you had an xsd and not a wsdl description you can use DefaultWsdl11Definition instead
         * example : https://www.springboottutorial.com/creating-soap-web-service-with-spring-boot-web-services-starter
         */
        wsdl11Definition.setWsdl(new ClassPathResource("/book.wsdl"));
        /*
         * We would create a WSDL based on the the one defined in the resources
         */
        return wsdl11Definition;
    }
}

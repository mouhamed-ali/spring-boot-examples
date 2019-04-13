package org.spring.boot.examples.multithreading.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
/*
 * @SpringBootApplication is a convenience annotation that adds all of the following:
 *
 * @Configuration tags the class as a source of bean definitions for the application context.
 * @EnableAutoConfiguration
 * Normally you would add @EnableWebMvc for a Spring MVC app, but Spring Boot adds it automatically when it sees spring-webmvc on the classpath.
 * This flags the application as a web application and activates key behaviors such as setting up a DispatcherServlet.
 * @ComponentScan tells Spring to look for other components, configurations, and services in the async package, allowing it to find the controllers.
 */
@EnableAsync
/*
 * The @EnableAsync annotation switches on Spring’s ability to run @Async methods in a background thread pool.
 */
public class Application {

    /*
     * you can find this example in spring io :
     * https://spring.io/guides/gs/async-method/
     */

    public static void main(String[] args) {
        // close the application context to shut down the custom ExecutorService
        SpringApplication.run(Application.class, args).close();
    }
}

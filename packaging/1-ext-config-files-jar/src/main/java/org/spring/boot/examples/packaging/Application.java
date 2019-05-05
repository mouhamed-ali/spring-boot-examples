package org.spring.boot.examples.packaging;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        System.setProperty("SPRING_CONFIG_NAME", "D:/tmp/config-files/");

        /*
         * you can use this :
         * System.setProperty("spring.config.location","D:/tmp/config-files/");
         */

        /*
         * you must exclude the yml files from the classpath. check pom.xml
         * you can even run the application using this commands :
         *
         * java -jar app.jar -Dspring.config.location:D:/tmp/config-files/
         * or
         * mvn spring-boot:run -Dspring.config.location="D:/tmp/config-files/"
         */

        /*
         * close the application context to shut down the custom ExecutorService
         */
        SpringApplication.run(Application.class, args).close();

        System.clearProperty("SPRING_CONFIG_NAME");
    }
}

package org.spring.boot.examples.properties.external;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PropertiesApplication {

    public static void main(String[] args) {

        System.setProperty("APP_HOME", "D:/tmp/config-files");
        //define our config directory - you can pass this parameter as a jvm property
        //you can find config files in the resources/configuration directory

        SpringApplication.run(PropertiesApplication.class, args).close();

        System.clearProperty("APP_HOME");
    }
}

package org.spring.boot.examples.packaging;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.util.Assert;

import java.io.File;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    public static final String CONFIG_DIRECTORY = "CONFIG_DIRECTORY_LOCATION";
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

        String configDir = System.getProperty(CONFIG_DIRECTORY);

        if (configDir == null) {
            configDir = System.getenv(CONFIG_DIRECTORY);
            LOGGER.warn("config directory loaded from env properties");
        }

        Assert.hasText(configDir, "the CONFIG_DIRECTORY_LOCATION is empty");

        if (!configDir.endsWith(File.separator))
            configDir += File.separator;

        LOGGER.info("config directory full path : {}", configDir);

        return
                builder
                        .properties("spring.config.location:" + configDir)
                        .sources(Application.class);

        /*
         * check this urls to know the if the application is up :
         * http://localhost:8080/2-ext-config-files-war/actuator/health
         * http://localhost:8080/2-ext-config-files-war/actuator/info
         */
    }
}

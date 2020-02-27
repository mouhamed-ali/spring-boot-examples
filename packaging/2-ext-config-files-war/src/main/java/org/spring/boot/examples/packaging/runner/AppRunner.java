package org.spring.boot.examples.packaging.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.boot.examples.packaging.config.ApplicationConfig;
import org.spring.boot.examples.packaging.config.DataSourceConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppRunner.class);
    private final ApplicationConfig applicationConfig;
    private final DataSourceConfig dataSourceConfig;

    public AppRunner(ApplicationConfig applicationConfig, DataSourceConfig dataSourceConfig) {
        this.applicationConfig = applicationConfig;
        this.dataSourceConfig = dataSourceConfig;
    }


    public void run(String... args) throws Exception {


        LOGGER.info("We are loading the {} datasource properties, the current user is {}",
                applicationConfig.getCurrentPlatform(),
                applicationConfig.getCurrentUser());
        LOGGER.info("{}", dataSourceConfig);
        LOGGER.info("loading properties ended successfully");
    }
}

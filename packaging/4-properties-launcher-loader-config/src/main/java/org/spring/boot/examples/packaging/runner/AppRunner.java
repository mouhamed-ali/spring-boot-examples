package org.spring.boot.examples.packaging.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.boot.examples.packaging.config.DataBaseConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppRunner.class);
    private final DataBaseConfig dataSourceConfig;

    public AppRunner(DataBaseConfig dataSourceConfig) {
        this.dataSourceConfig = dataSourceConfig;
    }

    public void run(String... args) throws Exception {


        LOGGER.info("###############      DataBase properties     ###############");
        LOGGER.info("### URL : {}     ", dataSourceConfig.getUrl());
        LOGGER.info("### USERNAME : {}", dataSourceConfig.getUser());
        LOGGER.info("### PASSWORD : {}", dataSourceConfig.getPassword());
        LOGGER.info("############################################################");

    }
}

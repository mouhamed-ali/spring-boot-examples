package org.spring.boot.examples.testing.override.config.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.boot.examples.testing.override.config.dao.ICityService;
import org.spring.boot.examples.testing.override.config.model.City;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppRunner.class);
    private final ICityService cityService;

    public AppRunner(ICityService cityService) {
        this.cityService = cityService;
    }

    @Override
    public void run(String... args) throws Exception {

        cityService.save(new City()
                .setName("Berlin")
                .setPopulation(3671000)
                .setDescription("This is a very long text for the PostgreSQL text column")
        );
        cityService.findAll().forEach(city -> LOGGER.debug("{}", city));
    }
}

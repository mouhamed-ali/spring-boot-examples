package org.spring.boot.examples.jpa.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.boot.examples.jpa.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppRunner.class);
    private EmployeeRepository employeeRepository;

    public AppRunner(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void run(String... args) throws Exception {

        LOGGER.info("### List of customers : ");
        employeeRepository.findAll().forEach(
                customer -> LOGGER.info("{}", customer)
        );
        LOGGER.info("### The operation ended successfully");
    }
}

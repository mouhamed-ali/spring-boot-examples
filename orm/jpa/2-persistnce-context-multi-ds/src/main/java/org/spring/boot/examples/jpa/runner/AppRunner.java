package org.spring.boot.examples.jpa.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.boot.examples.entities.Employee;
import org.spring.boot.examples.jpa.service.h2.EmployeeServiceH2;
import org.spring.boot.examples.jpa.service.postgres.EmployeeServicePostgres;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppRunner.class);
    private EmployeeServiceH2 employeeServiceH2;
    private EmployeeServicePostgres employeeServicePostgres;

    public AppRunner(EmployeeServiceH2 employeeServiceH2, EmployeeServicePostgres employeeServicePostgres) {
        this.employeeServiceH2 = employeeServiceH2;
        this.employeeServicePostgres = employeeServicePostgres;
    }

    public void run(String... args) throws Exception {

        LOGGER.info("### Create a H2 employee : ");
        employeeServiceH2.createEmployee(
                new Employee().setName("Paul").setSalary(35.8).setDeg("Developer")
        );
        LOGGER.info("### Create a postgres employee : ");
        employeeServicePostgres.createEmployee(
                new Employee().setName("John").setSalary(45.8).setDeg("Technical Manager")
        );

        LOGGER.info("### List of H2 employees : ");
        employeeServiceH2.findAll().forEach(
                employee -> LOGGER.info("{}", employee)
        );
        LOGGER.info("### List of Postgres employees : ");
        employeeServicePostgres.findAll().forEach(
                employee -> LOGGER.info("{}", employee)
        );
        LOGGER.info("### The operation ended successfully");
    }
}

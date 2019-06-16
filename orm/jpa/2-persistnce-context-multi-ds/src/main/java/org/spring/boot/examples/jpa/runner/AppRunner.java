package org.spring.boot.examples.jpa.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.boot.examples.entities.Employee;
import org.spring.boot.examples.jpa.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppRunner.class);
    private EmployeeRepository employeeRepositoryH2;
    private EmployeeRepository employeeRepositoryPostgres;

    public AppRunner(EmployeeRepository employeeRepositoryH2, EmployeeRepository employeeRepositoryPostrgres) {
        this.employeeRepositoryH2 = employeeRepositoryH2;
        this.employeeRepositoryPostgres = employeeRepositoryPostrgres;
    }

    public void run(String... args) throws Exception {

        LOGGER.info("### Create a H2 employee : ");
        employeeRepositoryH2.createEmployee(
                new Employee().setName("Paul").setSalary(35.8).setDeg("Developer")
        );
        LOGGER.info("### Create a postgres employee : ");
        employeeRepositoryPostgres.createEmployee(
                new Employee().setName("John").setSalary(45.8).setDeg("Technical Manager")
        );

        LOGGER.info("### List of H2 employees : ");
        employeeRepositoryH2.findAll().forEach(
                employee -> LOGGER.info("{}", employee)
        );
        LOGGER.info("### List of Postgres employees : ");
        employeeRepositoryPostgres.findAll().forEach(
                employee -> LOGGER.info("{}", employee)
        );
        LOGGER.info("### The operation ended successfully");
    }
}

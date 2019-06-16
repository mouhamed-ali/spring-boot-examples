package org.spring.boot.examples.jpa.repository.postgres;


import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.boot.examples.entities.Employee;
import org.spring.boot.examples.jpa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeRepositoryPostgresTest {

    @Autowired
    EmployeeRepository employeeRepositoryPostrgres;
    private Employee employee;

    @Before
    public void setUp() {

        employee = new Employee().setName("Alexandre").setSalary(90.75).setDeg("Technical Leader");
    }

    @Test
    @DirtiesContext
    public void createEmployeeTest() {

        employeeRepositoryPostrgres.createEmployee(employee);
        Employee createdEmployee = employeeRepositoryPostrgres.findByName("Alexandre");

        Assertions.assertThat(createdEmployee.getName()).isEqualTo("Alexandre");
        Assertions.assertThat(createdEmployee.getSalary()).isEqualTo(90.75);
        Assertions.assertThat(createdEmployee.getDeg()).isEqualTo("Technical Leader");
    }

    @Test(expected = EmptyResultDataAccessException.class)
    @DirtiesContext
    public void removeEmployeeTest() {

        employeeRepositoryPostrgres.createEmployee(employee);
        Employee toDeleteEmployee = employeeRepositoryPostrgres.findByName("Alexandre");

        employeeRepositoryPostrgres.removeEmployee(toDeleteEmployee);

        employeeRepositoryPostrgres.findByName("Alexandre");
    }

    @Test
    @DirtiesContext
    public void updateEmployeeTest() {

        employeeRepositoryPostrgres.createEmployee(employee);

        Employee toUpdateEmployee = employeeRepositoryPostrgres.findByName("Alexandre");

        toUpdateEmployee.setSalary(102.50);
        employeeRepositoryPostrgres.updateEmployee(toUpdateEmployee);

        toUpdateEmployee = employeeRepositoryPostrgres.findByName("Alexandre");

        Assertions.assertThat(toUpdateEmployee.getSalary()).isEqualTo(102.50);
    }
}

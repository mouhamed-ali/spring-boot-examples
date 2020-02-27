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
    EmployeeRepository employeeRepositoryPostgres;
    private Employee employee;

    @Before
    public void setUp() {

        employee = new Employee().setName("Alexandre").setSalary(90.75).setDeg("Technical Leader");
    }

    @Test
    @DirtiesContext
    public void createEmployeeTest() {

        employeeRepositoryPostgres.createEmployee(employee);
        Employee createdEmployee = employeeRepositoryPostgres.findByName("Alexandre");

        Assertions.assertThat(createdEmployee.getName()).isEqualTo("Alexandre");
        Assertions.assertThat(createdEmployee.getSalary()).isEqualTo(90.75);
        Assertions.assertThat(createdEmployee.getDeg()).isEqualTo("Technical Leader");
    }

    @Test(expected = EmptyResultDataAccessException.class)
    @DirtiesContext
    public void removeEmployeeTest() {

        employeeRepositoryPostgres.createEmployee(employee);
        Employee toDeleteEmployee = employeeRepositoryPostgres.findByName("Alexandre");

        employeeRepositoryPostgres.removeEmployee(toDeleteEmployee);

        employeeRepositoryPostgres.findByName("Alexandre");
    }

    @Test
    @DirtiesContext
    public void updateEmployeeTest() {

        employeeRepositoryPostgres.createEmployee(employee);

        Employee toUpdateEmployee = employeeRepositoryPostgres.findByName("Alexandre");

        toUpdateEmployee.setSalary(102.50);
        employeeRepositoryPostgres.updateEmployee(toUpdateEmployee);

        toUpdateEmployee = employeeRepositoryPostgres.findByName("Alexandre");

        Assertions.assertThat(toUpdateEmployee.getSalary()).isEqualTo(102.50);
    }
}

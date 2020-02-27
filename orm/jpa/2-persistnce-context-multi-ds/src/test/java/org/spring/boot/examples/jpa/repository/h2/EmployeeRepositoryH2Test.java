package org.spring.boot.examples.jpa.repository.h2;


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
public class EmployeeRepositoryH2Test {

    @Autowired
    EmployeeRepository employeeRepositoryH2;
    private Employee employee;

    @Before
    public void setUp() {

        employee = new Employee().setName("Charles").setSalary(50).setDeg("CEO");
    }

    @Test
    @DirtiesContext
    public void createEmployeeTest() {

        employeeRepositoryH2.createEmployee(employee);
        Employee createdEmployee = employeeRepositoryH2.findByName("Charles");

        Assertions.assertThat(createdEmployee.getName()).isEqualTo("Charles");
        Assertions.assertThat(createdEmployee.getSalary()).isEqualTo(50);
        Assertions.assertThat(createdEmployee.getDeg()).isEqualTo("CEO");
    }

    @Test(expected = EmptyResultDataAccessException.class)
    @DirtiesContext
    public void removeEmployeeTest() {

        employeeRepositoryH2.createEmployee(employee);
        Employee toDeleteEmployee = employeeRepositoryH2.findByName("Charles");

        employeeRepositoryH2.removeEmployee(toDeleteEmployee);

        employeeRepositoryH2.findByName("Charles");
    }

    @Test
    @DirtiesContext
    public void updateEmployeeTest() {

        employeeRepositoryH2.createEmployee(employee);

        Employee toUpdateEmployee = employeeRepositoryH2.findByName("Charles");

        toUpdateEmployee.setSalary(70);
        employeeRepositoryH2.updateEmployee(toUpdateEmployee);

        toUpdateEmployee = employeeRepositoryH2.findByName("Charles");

        Assertions.assertThat(toUpdateEmployee.getSalary()).isEqualTo(70);
    }
}

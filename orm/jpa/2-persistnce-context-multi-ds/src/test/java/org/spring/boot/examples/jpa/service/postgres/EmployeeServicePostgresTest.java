package org.spring.boot.examples.jpa.service.postgres;


import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.boot.examples.entities.Employee;
import org.spring.boot.examples.jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServicePostgresTest {

    private static Employee employee;

    @Autowired
    private EmployeeService employeeServicePostgres;

    @BeforeClass
    public static void setUp() {

        employee = new Employee().setName("Michael").setSalary(60.75).setDeg("Project Manager");
    }

    @Test
    public void createEmployeeTest() {

        employeeServicePostgres.createEmployee(employee);
    }

}

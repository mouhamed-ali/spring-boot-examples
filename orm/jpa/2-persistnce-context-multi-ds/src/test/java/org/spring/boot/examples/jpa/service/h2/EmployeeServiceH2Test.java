package org.spring.boot.examples.jpa.service.h2;


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
public class EmployeeServiceH2Test {

    private static Employee employee;

    @Autowired
    private EmployeeService employeeServiceH2;

    @BeforeClass
    public static void setUp() {

        employee = new Employee().setName("Jack").setSalary(40.9).setDeg("Architect");
    }

    @Test
    public void createEmployeeTest() {

        employeeServiceH2.createEmployee(employee);
    }

}

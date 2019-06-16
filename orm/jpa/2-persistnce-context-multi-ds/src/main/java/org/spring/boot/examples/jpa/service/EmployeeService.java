package org.spring.boot.examples.jpa.service;

import org.spring.boot.examples.entities.Employee;

import java.util.List;

public interface EmployeeService {

    void createEmployee(Employee employee);

    List<Employee> findAll();
}

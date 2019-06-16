package org.spring.boot.examples.jpa.repository;

import org.spring.boot.examples.entities.Employee;

import java.util.List;

public interface EmployeeRepository {

    List<Employee> findAll();

    void createEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    Employee findByName(String name);
}

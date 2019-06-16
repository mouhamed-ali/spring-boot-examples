package org.spring.boot.examples.jpa.service.postgres;

import org.spring.boot.examples.entities.Employee;
import org.spring.boot.examples.jpa.repository.EmployeeRepository;
import org.spring.boot.examples.jpa.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServicePostgres implements EmployeeService {

    private final EmployeeRepository employeeRepositoryPostrgres;

    public EmployeeServicePostgres(EmployeeRepository employeeRepositoryPostrgres) {
        this.employeeRepositoryPostrgres = employeeRepositoryPostrgres;
    }

    @Override
    public void createEmployee(Employee employee) {

        employeeRepositoryPostrgres.createEmployee(employee);
    }
}

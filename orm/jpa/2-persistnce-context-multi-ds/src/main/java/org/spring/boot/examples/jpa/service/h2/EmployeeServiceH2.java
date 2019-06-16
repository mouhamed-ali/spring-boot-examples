package org.spring.boot.examples.jpa.service.h2;

import org.spring.boot.examples.entities.Employee;
import org.spring.boot.examples.jpa.repository.EmployeeRepository;
import org.spring.boot.examples.jpa.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceH2 implements EmployeeService {

    private final EmployeeRepository employeeRepositoryH2;

    public EmployeeServiceH2(EmployeeRepository employeeRepositoryH2) {
        this.employeeRepositoryH2 = employeeRepositoryH2;
    }

    @Transactional("postgresTransactionManager")
    @Override
    public void createEmployee(Employee employee) {

        employeeRepositoryH2.createEmployee(employee);
    }
}

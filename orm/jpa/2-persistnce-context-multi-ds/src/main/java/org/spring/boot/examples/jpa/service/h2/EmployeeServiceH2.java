package org.spring.boot.examples.jpa.service.h2;

import org.spring.boot.examples.entities.Employee;
import org.spring.boot.examples.jpa.repository.EmployeeRepository;
import org.spring.boot.examples.jpa.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceH2 implements EmployeeService {

    private final EmployeeRepository employeeRepositoryH2;

    public EmployeeServiceH2(EmployeeRepository employeeRepositoryH2) {
        this.employeeRepositoryH2 = employeeRepositoryH2;
    }

    @Transactional("postgresTransactionManager")
    /*
     * don't use this annotation in a read project
     * in this example we will start the method with a postgres transaction but in the repository layer we will
     * stop it and start a new h2 transaction
     * in a real project you will use h2TransactionManager
     */
    @Override
    public void createEmployee(Employee employee) {

        employeeRepositoryH2.createEmployee(employee);
    }

    @Override
    public List<Employee> findAll() {

        return employeeRepositoryH2.findAll();
    }
}

package org.spring.boot.examples.jpa.service.postgres;

import org.spring.boot.examples.entities.Employee;
import org.spring.boot.examples.jpa.repository.EmployeeRepository;
import org.spring.boot.examples.jpa.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServicePostgres implements EmployeeService {

    private final EmployeeRepository employeeRepositoryPostgres;

    public EmployeeServicePostgres(EmployeeRepository employeeRepositoryPostgres) {
        this.employeeRepositoryPostgres = employeeRepositoryPostgres;
    }

    @Transactional("h2TransactionManager")
    /*
     * don't use this annotation in a read project
     * in this example we will start the method with a postgres transaction but in the repository layer we will
     * stop it and start a new h2 transaction
     * in a real project you will use postgresTransactionManager
     */
    @Override
    public void createEmployee(Employee employee) {

        employeeRepositoryPostgres.createEmployee(employee);
    }

    @Override
    public List<Employee> findAll() {

        return employeeRepositoryPostgres.findAll();
    }
}

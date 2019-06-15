package org.spring.boot.examples.jpa.repository;

import org.spring.boot.examples.entities.Customer;

import java.util.List;

public interface EmployeeRepository {

    List<Customer> findAll();
}

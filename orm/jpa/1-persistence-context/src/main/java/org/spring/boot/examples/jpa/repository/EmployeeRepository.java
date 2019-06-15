package org.spring.boot.examples.jpa.repository;

import org.spring.boot.examples.entities.Customer;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface EmployeeRepository {

    List<Customer> findAll();

    void createCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    void removeCustomer(Customer customer);

    Customer getCustomerById(Long id);

    void removeCustomerById(Long id);

    void commitTransaction();
}

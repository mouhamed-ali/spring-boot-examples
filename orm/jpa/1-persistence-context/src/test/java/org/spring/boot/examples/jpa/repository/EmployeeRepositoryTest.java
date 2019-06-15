package org.spring.boot.examples.jpa.repository;

import org.assertj.core.api.Assertions;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.boot.examples.entities.Account;
import org.spring.boot.examples.entities.Address;
import org.spring.boot.examples.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeRepositoryTest {

    public static Customer customer;

    @Autowired
    EmployeeRepository employeeRepository;

    @BeforeClass
    public static void setUp() {

        Account account = new Account().setId(99L).setBalance(51.0).setDateOpened(LocalDate.now());
        customer = new Customer().setId(99L).setEmail("email@gmail.com").addAccount(account);
        new Address().setId(99L).setBuilding("Orthia").setCountry("France").setCustomer(customer);
    }

    @Test
    @DirtiesContext // at the start we have three customers
    public void findAllTest() {

        List<Customer> customers = employeeRepository.findAll();
        Assertions.assertThat(customers.size()).isEqualTo(3);
    }

    @Test
    @DirtiesContext // at the start we have three customers
    public void createCustomerTest() {

        employeeRepository.createCustomer(customer);

        Customer persistedCustomer = employeeRepository.getCustomerById(99L);

        Assertions.assertThat(persistedCustomer.getEmail()).isEqualTo("email@gmail.com");

        Assertions.assertThat(persistedCustomer.getAddress().getBuilding()).isEqualTo("Orthia");
        Assertions.assertThat(persistedCustomer.getAddress().getCountry()).isEqualTo("France");

        Assertions.assertThat(persistedCustomer.getAccounts().size()).isEqualTo(1);
        Assertions.assertThat(persistedCustomer.getAccounts().get(0).getBalance()).isEqualTo(51.0);
        Assertions.assertThat(persistedCustomer.getAccounts().get(0).getDateOpened()).isEqualTo(LocalDate.now());

    }

    @Test
    @DirtiesContext
    public void updateCustomerTest() {

        Customer toUpdateCustomer = employeeRepository.getCustomerById(1L);
        toUpdateCustomer.setEmail("new.email@mail.com");
        new Address().setId(99L).setBuilding("Orthia").setCountry("France").setCustomer(toUpdateCustomer);

        toUpdateCustomer = employeeRepository.updateCustomer(toUpdateCustomer);

        Assertions.assertThat(toUpdateCustomer.getEmail()).isEqualTo("new.email@mail.com");
        Assertions.assertThat(toUpdateCustomer.getAddress().getId()).isEqualTo(99L);
    }

    @Test
    @DirtiesContext
    public void removeCustomerTest() {

        Customer toDeleteCustomer = employeeRepository.getCustomerById(1L);

        employeeRepository.removeCustomer(toDeleteCustomer);

        List<Customer> customers = employeeRepository.findAll();
        List<Long> ids = customers.stream().map(Customer::getId).collect(Collectors.toList());

        Assertions.assertThat(ids).containsExactly(2L, 3L);
    }

    @Test
    @DirtiesContext
    public void removeCustomerByIdTest() {

        employeeRepository.removeCustomerById(2L);

        List<Customer> customers = employeeRepository.findAll();
        List<Long> ids = customers.stream().map(Customer::getId).collect(Collectors.toList());

        Assertions.assertThat(ids).containsExactly(1L, 3L);
    }
}

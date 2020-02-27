package org.spring.boot.examples.jpa.repository.impl;

import org.spring.boot.examples.entities.Customer;
import org.spring.boot.examples.jpa.repository.EmployeeRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private EntityManager entityManager;

    @Override
    public List<Customer> findAll() {

        Query query = entityManager.createQuery("SELECT e FROM Customer e");
        return query.getResultList();
    }

    @Override
    public void createCustomer(Customer customer) {

        entityManager.persist(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {

        return entityManager.merge(customer);
    }

    @Override
    public void removeCustomer(Customer customer) {

        entityManager.remove(
                entityManager.contains(customer) ? customer : entityManager.merge(customer)
        );
    }

    @Override
    public Customer getCustomerById(Long id) {

        return entityManager.find(Customer.class, id);
    }

    @Override
    public void removeCustomerById(Long id) {

        entityManager.remove(
                getCustomerById(id)
        );
    }

    @Override
    public void commitTransaction() {
        entityManager.flush();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}

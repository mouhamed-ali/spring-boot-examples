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

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}

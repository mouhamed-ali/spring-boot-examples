package org.spring.boot.examples.jpa.repository;

import org.spring.boot.examples.entities.Employee;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public abstract class AbstractEmployeeRepository implements EmployeeRepository {

    private EntityManager entityManager;

    @Override
    public List<Employee> findAll() {

        Query query = entityManager.createQuery("SELECT e FROM Employee e");
        return query.getResultList();
    }

    @Override
    public void createEmployee(Employee employee) {

        entityManager.persist(employee);
    }

    @Transactional("postgresTransactionManager")
    @Override
    public Employee updateEmployee(Employee employee) {

        return entityManager.merge(employee);
    }

    @Override
    public Employee findByName(String name) {

        Query query = entityManager.createQuery("SELECT e FROM Employee e where e.name = :name")
                .setParameter("name", name);

        return (Employee) query.getSingleResult();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}

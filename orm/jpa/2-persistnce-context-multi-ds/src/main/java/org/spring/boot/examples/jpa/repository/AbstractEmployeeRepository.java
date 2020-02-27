package org.spring.boot.examples.jpa.repository;

import org.spring.boot.examples.entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public abstract class AbstractEmployeeRepository implements EmployeeRepository {

    private EntityManager entityManager;

    /*
     * select queries didn't need to be transactional
     */
    @Override
    public List<Employee> findAll() {

        Query query = entityManager.createQuery("SELECT e FROM Employee e");
        return query.getResultList();
    }

    @Override
    public void createEmployee(Employee employee) {

        entityManager.persist(employee);
    }

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

    @Override
    public void removeEmployee(Employee employee) {

        entityManager.remove(
                entityManager.contains(employee) ? employee : entityManager.merge(employee)
        );
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}

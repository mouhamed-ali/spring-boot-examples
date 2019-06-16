package org.spring.boot.examples.jpa.repository.postgres;

import org.spring.boot.examples.entities.Employee;
import org.spring.boot.examples.jpa.repository.AbstractEmployeeRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class EmployeeRepositoryPostrgres extends AbstractEmployeeRepository {


    @Transactional(value = "postgresTransactionManager", propagation = Propagation.REQUIRES_NEW)
    @Override
    public void createEmployee(Employee employee) {
        super.createEmployee(employee);
    }

    @Transactional("postgresTransactionManager")
    /*
     * the create entity method is transactional
     * the @Transactional annotation takes the transaction manager name as parameter
     */
    @Override
    public Employee updateEmployee(Employee employee) {
        return super.updateEmployee(employee);
    }

    @Transactional("postgresTransactionManager")
    @Override
    public void removeEmployee(Employee employee) {
        super.removeEmployee(employee);
    }

    @PersistenceContext(unitName = "postgresPU")
    @Override
    public void setEntityManager(EntityManager entityManager) {
        super.setEntityManager(entityManager);
    }
}

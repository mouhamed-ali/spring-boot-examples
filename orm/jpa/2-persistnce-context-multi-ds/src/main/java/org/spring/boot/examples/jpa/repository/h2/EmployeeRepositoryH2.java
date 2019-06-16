package org.spring.boot.examples.jpa.repository.h2;

import org.spring.boot.examples.entities.Employee;
import org.spring.boot.examples.jpa.repository.AbstractEmployeeRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class EmployeeRepositoryH2 extends AbstractEmployeeRepository {

    @Transactional(value = "h2TransactionManager", propagation = Propagation.REQUIRES_NEW)
    /*
     * you can put this annotation on the class name or in the service layer. in that case all methods will be
     * transactional
     */
    @Override
    public void createEmployee(Employee employee) {
        super.createEmployee(employee);
    }

    @Transactional("h2TransactionManager")
    @Override
    public Employee updateEmployee(Employee employee) {

        return super.updateEmployee(employee);
    }

    @PersistenceContext(unitName = "h2PU")
    @Override
    public void setEntityManager(EntityManager entityManager) {
        super.setEntityManager(entityManager);
    }
}

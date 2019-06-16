package org.spring.boot.examples.jpa.repository.h2;

import org.spring.boot.examples.entities.Employee;
import org.spring.boot.examples.jpa.repository.AbstractEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class EmployeeRepositoryH2 extends AbstractEmployeeRepository {

    @Autowired
    @Qualifier("h2TransactionManager")
    private PlatformTransactionManager transactionManager;

    @Transactional("h2TransactionManager")
    @Override
    public Employee updateEmployee(Employee employee) {

        return super.updateEmployee(employee);
    }

    @Transactional(value = "h2TransactionManager", propagation = Propagation.REQUIRES_NEW)
    /*
     * you can put this annotation on the class name or in the service layer. in that case all methods will be
     * transactional
     * in this method we gonna close the current transaction (created by service layer) and create a new one
     */
    @Override
    public void createEmployee(Employee employee) {
        super.createEmployee(employee);
    }

    /*
     * in this method we will not use the annotation to create a transaction
     */
    @Override
    public void removeEmployee(Employee employee) {

        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
        transactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {

                getEntityManager().remove(
                        getEntityManager().contains(employee) ? employee : getEntityManager().merge(employee)
                );
            }
        });
    }

    /*
     * in this method we have defined the datasource to be used
     */
    @PersistenceContext(unitName = "h2PU")
    @Override
    public void setEntityManager(EntityManager entityManager) {
        super.setEntityManager(entityManager);
    }
}

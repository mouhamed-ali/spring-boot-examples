package org.spring.boot.examples.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Account implements Serializable {

    private static final long serialVersionUID = 9081933484652249500L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_name")
    private String accountName;

    private Double balance;

    @Column(name = "date_opened", columnDefinition = "DATE")
    private LocalDate dateOpened;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Long getId() {
        return id;
    }

    public Account setId(Long id) {
        this.id = id;
        return this;
    }

    public String getAccountName() {
        return accountName;
    }

    public Account setAccountName(String accountName) {
        this.accountName = accountName;
        return this;
    }

    public Double getBalance() {
        return balance;
    }

    public Account setBalance(Double balance) {
        this.balance = balance;
        return this;
    }

    public LocalDate getDateOpened() {
        return dateOpened;
    }

    public Account setDateOpened(LocalDate dateOpened) {
        this.dateOpened = dateOpened;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    /**
     * this method is used to add a customer to the current of the current account
     * don't use it with big lists
     *
     * @param customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;

        // warning this may cause performance issues if you have a large data set since this operation is O(n)
        if (!customer.getAccounts().contains(this)) {
            customer.getAccounts().add(this);
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountName='" + accountName + '\'' +
                ", balance=" + balance +
                ", dateOpened=" + dateOpened +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

package com.learning.DTO_Demo01.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private int accountNumber;
    @Column(name = "user_name")
    private String name;
    private String accountType;
    private String password;
    private double balance;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference // owning side
    private Address address;

    public Bank() {
    }

    public Bank(long id, int accountNumber, String name, String accountType, String password, double balance, Address address) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.name = name;
        this.accountType = accountType;
        this.password = password;
        this.balance = balance;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", accountNumber=" + accountNumber +
                ", name='" + name + '\'' +
                ", accountType='" + accountType + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", address=" + address +
                '}';
    }
}

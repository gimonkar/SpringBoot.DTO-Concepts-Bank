package com.learning.DTO_Demo01.dtos;

import jakarta.persistence.*;

public class AccountDTO {
    private long id;
    private int accountNumber;
    private String name;
    private String accountType;

    public AccountDTO() {
    }

    public AccountDTO(int accountNumber, String name, String accountType, int id) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.accountType = accountType;
        this.id = id;
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

    @Override
    public String toString() {
        return "AccountDTO{" +
                "id=" + id +
                ", accountNumber=" + accountNumber +
                ", name='" + name + '\'' +
                ", accountType='" + accountType + '\'' +
                '}';
    }
}

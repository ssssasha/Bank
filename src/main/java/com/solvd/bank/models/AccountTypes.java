package com.solvd.bank.models;

import java.util.List;

public class AccountTypes {

    private int id;
    private String name;
    private List<Accounts> accounts;

    public AccountTypes() {
    }

    public AccountTypes(int id, String name, List<Accounts> accounts) {
        this.id = id;
        this.name = name;
        this.accounts = accounts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Accounts> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Accounts> accounts) {
        this.accounts = accounts;
    }
}

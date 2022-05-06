package com.solvd.bank.models;

public class Accounts {

    private int id;
    private String number;
    private Clients client;
    private AccountTypes accountType;

    public Accounts() {
    }

    public Accounts(int id, String number, Clients client, AccountTypes accountType) {
        this.id = id;
        this.number = number;
        this.client = client;
        this.accountType = accountType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    public AccountTypes getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountTypes accountType) {
        this.accountType = accountType;
    }
}

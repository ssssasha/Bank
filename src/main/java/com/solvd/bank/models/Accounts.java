package com.solvd.bank.models;

public class Accounts {

    private int id;
    private int clientId;
    private int accountTypeId;
    private String number;
    private Clients client;
    private AccountTypes accountType;

    public Accounts() {
    }

    public Accounts(int id) {
        this.id = id;
    }

    public Accounts(Clients client, AccountTypes accountType, String number) {
        this.client = client;
        this.accountType = accountType;
        this.number = number;
    }

    public Accounts(int id, Clients client, AccountTypes accountType, String number) {
        this.id = id;
        this.client = client;
        this.accountType = accountType;
        this.number = number;
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

    @Override
    public String toString() {
        return "\n id: " + getId()+ "\n\n " + "client: " + getClient() + "\n\n " + "accountType: " + getAccountType()
                + "\n\n " + "number: " + getNumber();
    }
}

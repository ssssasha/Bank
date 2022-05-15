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

    public Accounts(int clientId, int accountTypeId, String number) {
        this.clientId = clientId;
        this.accountTypeId = accountTypeId;
        this.number = number;
    }

    public Accounts(int id, int clientId, int accountTypeId, String number) {
        this.id = id;
        this.clientId = clientId;
        this.accountTypeId = accountTypeId;
        this.number = number;
    }

    public Accounts(int id, int clientId, int accountTypeId, String number, Clients client, AccountTypes accountType) {
        this.id = id;
        this.clientId = clientId;
        this.accountTypeId = accountTypeId;
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

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(int accountTypeId) {
        this.accountTypeId = accountTypeId;
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
        return "\n id: " + getId()+ "\n " + "clientId: " + getClientId() + "\n " + "accountTypeId: " + getAccountTypeId()
                + "\n " + "number: " + getNumber();
    }
}

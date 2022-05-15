package com.solvd.bank.models;

public class Credits {

    private int id;
    private int clientId;
    private int bankId;
    private int creditTypeId;
    private double rate;
    private int term;
    private int maximumAmount;
    private Clients client;
    private Banks bank;
    private CreditTypes creditType;

    public Credits() {
    }

    public Credits(int clientId, int bankId, int creditTypeId, double rate, int term, int maximumAmount) {
        this.clientId = clientId;
        this.bankId = bankId;
        this.creditTypeId = creditTypeId;
        this.rate = rate;
        this.term = term;
        this.maximumAmount = maximumAmount;
    }

    public Credits(int id, int clientId, int bankId, int creditTypeId, double rate, int term, int maximumAmount) {
        this.id = id;
        this.clientId = clientId;
        this.bankId = bankId;
        this.creditTypeId = creditTypeId;
        this.rate = rate;
        this.term = term;
        this.maximumAmount = maximumAmount;
    }

    public Credits(int id, int clientId, int bankId, int creditTypeId, double rate, int term, int maximumAmount, Clients client, Banks bank, CreditTypes creditType) {
        this.id = id;
        this.clientId = clientId;
        this.bankId = bankId;
        this.creditTypeId = creditTypeId;
        this.rate = rate;
        this.term = term;
        this.maximumAmount = maximumAmount;
        this.client = client;
        this.bank = bank;
        this.creditType = creditType;
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

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public int getCreditTypeId() {
        return creditTypeId;
    }

    public void setCreditTypeId(int creditTypeId) {
        this.creditTypeId = creditTypeId;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public int getMaximumAmount() {
        return maximumAmount;
    }

    public void setMaximumAmount(int maximumAmount) {
        this.maximumAmount = maximumAmount;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    public Banks getBank() {
        return bank;
    }

    public void setBank(Banks bank) {
        this.bank = bank;
    }

    public CreditTypes getCreditType() {
        return creditType;
    }

    public void setCreditType(CreditTypes creditType) {
        this.creditType = creditType;
    }

    @Override
    public String toString() {
        return "\n id: " + getId()+ "\n " + "term: " + getTerm();
    }
}

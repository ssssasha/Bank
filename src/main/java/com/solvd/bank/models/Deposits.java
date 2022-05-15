package com.solvd.bank.models;

public class Deposits {

    private int id;
    private int clientId;
    private int bankId;
    private int minimumContribution;
    private int percentagePerAnnum;
    private int term;
    private Clients client;
    private Banks bank;

    public Deposits() {
    }

    public Deposits(int clientId, int bankId, int minimumContribution, int percentagePerAnnum, int term) {
        this.clientId = clientId;
        this.bankId = bankId;
        this.minimumContribution = minimumContribution;
        this.percentagePerAnnum = percentagePerAnnum;
        this.term = term;
    }

    public Deposits(int id, int clientId, int bankId, int minimumContribution, int percentagePerAnnum, int term) {
        this.id = id;
        this.clientId = clientId;
        this.bankId = bankId;
        this.minimumContribution = minimumContribution;
        this.percentagePerAnnum = percentagePerAnnum;
        this.term = term;
    }

    public Deposits(int id, int clientId, int bankId, int minimumContribution, int percentagePerAnnum, int term, Clients client, Banks bank) {
        this.id = id;
        this.clientId = clientId;
        this.bankId = bankId;
        this.minimumContribution = minimumContribution;
        this.percentagePerAnnum = percentagePerAnnum;
        this.term = term;
        this.client = client;
        this.bank = bank;
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

    public int getMinimumContribution() {
        return minimumContribution;
    }

    public void setMinimumContribution(int minimumContribution) {
        this.minimumContribution = minimumContribution;
    }

    public int getPercentagePerAnnum() {
        return percentagePerAnnum;
    }

    public void setPercentagePerAnnum(int percentagePerAnnum) {
        this.percentagePerAnnum = percentagePerAnnum;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
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

    @Override
    public String toString() {
        return "\n id: " + getId()+ "\n " + "minimumContribution: " + getMinimumContribution() + "\n " + "term: " + getTerm();
    }
}

package com.solvd.bank.models;

public class Deposits {

    private int id;
    private Clients client;
    private Banks bank;
    private int minimumContribution;
    private int percentagePerAnnum;
    private int term;

    public Deposits() {
    }

    public Deposits(Clients client, Banks bank, int minimumContribution, int percentagePerAnnum, int term) {
        this.client = client;
        this.bank = bank;
        this.minimumContribution = minimumContribution;
        this.percentagePerAnnum = percentagePerAnnum;
        this.term = term;
    }


    public Deposits(int id, Clients client, Banks bank, int minimumContribution, int percentagePerAnnum, int term) {
        this.id = id;
        this.client = client;
        this.bank = bank;
        this.minimumContribution = minimumContribution;
        this.percentagePerAnnum = percentagePerAnnum;
        this.term = term;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "\n id: " + getId() + "\n\n " + "client: " + getClient() + "\n\n " + "bank: " + getBank() + "\n\n " +
                "minimumContribution: " + getMinimumContribution() + "\n " + "percentagePerAnnum: "
                + getPercentagePerAnnum() + "\n " + "term: " + getTerm();
    }
}

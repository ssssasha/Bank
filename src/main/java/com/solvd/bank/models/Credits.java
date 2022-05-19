package com.solvd.bank.models;

public class Credits {

    private int id;
    private Clients client;
    private Banks bank;
    private CreditTypes creditType;
    private double rate;
    private int term;
    private int maximumAmount;

    public Credits() {
    }

    public Credits(Clients client, Banks bank, CreditTypes creditType, double rate, int term, int maximumAmount) {
        this.client = client;
        this.bank = bank;
        this.creditType = creditType;
        this.rate = rate;
        this.term = term;
        this.maximumAmount = maximumAmount;
    }

    public Credits(int id, Clients client, Banks bank, CreditTypes creditType, double rate, int term, int maximumAmount) {
        this.id = id;
        this.client = client;
        this.bank = bank;
        this.creditType = creditType;
        this.rate = rate;
        this.term = term;
        this.maximumAmount = maximumAmount;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "\n id: " + getId() + "\n\n " + "Client: " + getClient() + "\n\n " + "Bank: "
                + getBank() + "\n\n " + "CreditType: " + getCreditType()+ "\n\n " + "Rate: " + getRate()
                +  "\n " + "term: " + getTerm() + "\n " + "Maximum amount: " + getMaximumAmount();
    }
}

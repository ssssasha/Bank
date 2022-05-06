package com.solvd.bank.models;

public class Cards {

    private int id;
    private String number;
    private Clients client;
    private CardTypes cardType;

    public Cards() {
    }

    public Cards(int id, String number, Clients client, CardTypes cardType) {
        this.id = id;
        this.number = number;
        this.client = client;
        this.cardType = cardType;
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

    public CardTypes getCardType() {
        return cardType;
    }

    public void setCardType(CardTypes cardType) {
        this.cardType = cardType;
    }
}

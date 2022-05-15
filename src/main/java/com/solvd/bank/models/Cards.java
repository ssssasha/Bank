package com.solvd.bank.models;

public class Cards {

    private int id;
    private int cardTypeId;
    private int clientId;
    private String number;
    private Clients client;
    private CardTypes cardType;

    public Cards() {
    }

    public Cards(int cardTypeId, int clientId) {
        this.cardTypeId = cardTypeId;
        this.clientId = clientId;
    }

    public Cards(int id, int cardTypeId, int clientId) {
        this.id = id;
        this.cardTypeId = cardTypeId;
        this.clientId = clientId;
    }

    public Cards(int id, int cardTypeId, int clientId, String number, Clients client, CardTypes cardType) {
        this.id = id;
        this.cardTypeId = cardTypeId;
        this.clientId = clientId;
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

    public int getCardTypeId() {
        return cardTypeId;
    }

    public void setCardTypeId(int cardTypeId) {
        this.cardTypeId = cardTypeId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
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

    @Override
    public String toString() {
        return "\n id: " + getId()+ "\n " + "number: " + getNumber();
    }
}

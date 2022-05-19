package com.solvd.bank.models;

public class Cards {

    private int id;
    private CardTypes cardType;
    private Clients client;
    private String number;

    public Cards() {
    }

    public Cards(int cardType, int client) {

    }

    public Cards(int id, int cardType, int client) {
        this.id = id;

    }

    public Cards(int id , CardTypes cardType , Clients client , String number) {
        this.id = id;
        this.cardType = cardType;
        this.client = client;
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

    public CardTypes getCardType() {
        return cardType;
    }

    public void setCardType(CardTypes cardType) {
        this.cardType = cardType;
    }

    @Override
    public String toString() {
        return "\n id: " + getId()  + "\n\n " + "card type: " + getCardType()  + "\n\n " + "client: " + getClient()
                + "\n\n " + "number: " + getNumber();
    }
}

package com.solvd.bank.models;

import java.util.List;

public class CardTypes {

    private int id;
    private String name;
    private List<Cards> cards;

    public CardTypes() {
    }

    public CardTypes(int id, String name, List<Cards> cards) {
        this.id = id;
        this.name = name;
        this.cards = cards;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cards> getCards() {
        return cards;
    }

    public void setCards(List<Cards> cards) {
        this.cards = cards;
    }
}

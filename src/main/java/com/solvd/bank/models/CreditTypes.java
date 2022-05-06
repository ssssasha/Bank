package com.solvd.bank.models;

import java.util.List;

public class CreditTypes {

    private int id;
    private String name;
    private List<Credits> credits;

    public CreditTypes() {
    }

    public CreditTypes(int id, String name, List<Credits> credits) {
        this.id = id;
        this.name = name;
        this.credits = credits;
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

    public List<Credits> getCredits() {
        return credits;
    }

    public void setCredits(List<Credits> credits) {
        this.credits = credits;
    }
}

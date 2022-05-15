package com.solvd.bank.models;

import java.util.List;

public class Streets {

    private int id;
    private String name;
    private List<Addresses> addresses;

    public Streets(){
    };

    public Streets(String name) {
        this.name = name;
    }

    public Streets(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Streets(int id, String name, List<Addresses> addresses) {
        this.id = id;
        this.name = name;
        this.addresses = addresses;
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

    public List<Addresses> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Addresses> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "\n id: " + getId()+ "\n " + "name: " + getName();
    }
}

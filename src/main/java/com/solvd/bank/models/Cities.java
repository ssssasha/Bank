package com.solvd.bank.models;

import java.util.List;

public class Cities {

    private int id;
    private String name;
    private List<Addresses> addresses;

    public Cities() {
    }

    public Cities(int id, String name, List<Addresses> addresses) {
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
}

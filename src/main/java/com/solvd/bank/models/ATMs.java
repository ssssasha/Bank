package com.solvd.bank.models;

public class ATMs {

    private int id;
    private Banks bank;
    private Addresses address;

    public ATMs() {
    }

    public ATMs(int id) {
        this.id = id;
    }

    public ATMs(Banks bank, Addresses address) {
        this.bank = bank;
        this.address = address;
    }

    public ATMs(int id, Banks bank, Addresses address) {
        this.id = id;
        this.bank = bank;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Banks getBank() {
        return bank;
    }

    public void setBank(Banks bank) {
        this.bank = bank;
    }

    public Addresses getAddress() {
        return address;
    }

    public void setAddress(Addresses address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "\n id: " + getId() + "\n\n" + "bankId: " + getBank() + "\n\n" + "addressId: " + getAddress();
    }
}

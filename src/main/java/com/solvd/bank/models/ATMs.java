package com.solvd.bank.models;

public class ATMs {

    private int id;
    private int bankId;
    private int addressId;
    private Banks bank;
    private Addresses address;

    public ATMs() {
    }

    public ATMs(int bankId, int addressId) {
        this.bankId = bankId;
        this.addressId = addressId;
    }

    public ATMs(int id, int bankId, int addressId) {
        this.id = id;
        this.bankId = bankId;
        this.addressId = addressId;
    }

    public ATMs(int id, int bankId, int addressId, Banks bank, Addresses address) {
        this.id = id;
        this.bankId = bankId;
        this.addressId = addressId;
        this.bank = bank;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.id = addressId;
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
        return "\n id: " + getId()+ "\n " + "bankId: " + getBankId();
    }
}

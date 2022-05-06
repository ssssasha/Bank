package com.solvd.bank.models;

import java.util.List;

public class Addresses {

    private int id;
    private int buildingNumber;
    private Cities city;
    private Streets street;
    private List<ATMs> atms;
    private List<Clients> clients;

    public Addresses() {
    }

    public Addresses(int id, int buildingNumber, Cities city, Streets street, List<ATMs> atms, List<Clients> clients) {
        this.id = id;
        this.buildingNumber = buildingNumber;
        this.city = city;
        this.street = street;
        this.atms = atms;
        this.clients = clients;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBuildingNumberNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public Cities getCities() {
        return city;
    }

    public void setCities(Cities city) {
        this.city = city;
    }

    public Streets getStreets() {
        return street;
    }

    public void setStreets(Streets street) {
        this.street = street;
    }

    public List<ATMs> getAtms() {
        return atms;
    }

    public void setAtms(List<ATMs> atms) {
        this.atms = atms;
    }

    public List<Clients> getClients() {
        return clients;
    }

    public void setClients(List<Clients> clients) {
        this.clients = clients;
    }

}

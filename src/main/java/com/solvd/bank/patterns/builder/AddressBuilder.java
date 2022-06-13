package com.solvd.bank.patterns.builder;

public class AddressBuilder {
    private String city;
    private String street;
    private int buildingNumber;

    public AddressBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public AddressBuilder setStreet(String street) {
        this.street = street;
        return this;
    }

    public AddressBuilder setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
        return this;
    }

    public Address getAddress() {
        return new Address(city, street, buildingNumber);
    }
}

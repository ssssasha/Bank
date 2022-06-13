package com.solvd.bank.patterns.builder;

import com.solvd.bank.models.ATMs;
import com.solvd.bank.models.Cities;
import com.solvd.bank.models.Clients;
import com.solvd.bank.models.Streets;

import java.util.List;

public class Address {
    private static String city;
    private static String street;
    private static int buildingNumber;

    public Address() {
    }

    public Address(String city, String street, int buildingNumber){
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
    }

    public static String getCity() {
        return city;
    }

    public static String getStreet() {
        return street;
    }

    public static int getBuildingNumber() {
        return buildingNumber;
    }

    @Override
    public String toString() {
        return "\n city: " + city + "\n\n" + "street: " + street
                + "\n\n" + "building number: " + buildingNumber;
    }
}

package com.solvd.bank.models;

import java.util.List;

public class Banks {

    private int id;
    private String name;
    private int phoneNumber;
    private List<Credits> credits;
    private List<Deposits> deposits;
    private List<ATMs> atms;
    private List<Departments> departments;

    public Banks() {
    }

    public Banks(int id, String name, int phoneNumber, List<Credits> credits, List<Deposits> deposits, List<ATMs> atms,
                 List<Departments> departments) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.credits = credits;
        this.deposits = deposits;
        this.atms = atms;
        this.departments = departments;
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Credits> getCredits() {
        return credits;
    }

    public void setCredits(List<Credits> credits) {
        this.credits = credits;
    }

    public List<Deposits> getDeposits() {
        return deposits;
    }

    public void setDeposits(List<Deposits> deposits) {
        this.deposits = deposits;
    }

    public List<ATMs> getAtms() {
        return atms;
    }

    public void setAtms(List<ATMs> atms) {
        this.atms = atms;
    }

    public List<Departments> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Departments> departments) {
        this.departments = departments;
    }
}

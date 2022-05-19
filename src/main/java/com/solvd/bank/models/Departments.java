package com.solvd.bank.models;

public class Departments {

    private int id;
    private Banks bank;
    private Addresses address;
    private Schedules schedule;

    public Departments() {
    }

    public Departments(Banks bank, Addresses address, Schedules schedule) {
        this.bank = bank;
        this.address = address;
        this.schedule = schedule;
    }

    public Departments(int id, Banks bank, Addresses address, Schedules schedule) {
        this.id = id;
        this.bank = bank;
        this.address = address;
        this.schedule = schedule;
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

    public Schedules getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedules schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "\n id: " + getId()+ "\n " + "bank: " + getBank() + "\n " + "address: " + getAddress()
                + "\n " + "schedule: " + getSchedule();
    }
}

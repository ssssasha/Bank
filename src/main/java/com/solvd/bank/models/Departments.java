package com.solvd.bank.models;

public class Departments {

    private int id;
    private int bankId;
    private int addressId;
    private int scheduleId;
    private Banks bank;
    private Addresses address;
    private Schedules schedule;

    public Departments() {
    }

    public Departments(int bankId, int addressId, int scheduleId) {
        this.bankId = bankId;
        this.addressId = addressId;
        this.scheduleId = scheduleId;
    }

    public Departments(int day, int bankId, int addressId, int scheduleId) {
        this.bankId = bankId;
        this.addressId = addressId;
        this.scheduleId = scheduleId;
    }

    public Departments(int day, int bankId, int addressId, int scheduleId, Banks bank, Addresses address, Schedules schedule) {
        this.id = id;
        this.bankId = bankId;
        this.addressId = addressId;
        this.scheduleId = scheduleId;
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
        this.addressId = addressId;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
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
        return "\n id: " + getId()+ "\n " + "bankId: " + getBankId() + "\n " + "addressId: " + getAddressId()
                + "\n " + "scheduleId: " + getScheduleId();
    }
}

package com.solvd.bank.models;

import java.util.List;

public class Schedules {

    private int id;
    private String openingTime;
    private String closingTime;
    private String day;
    private List<Departments> departments;

    public Schedules() {
    }

    public Schedules(String openingTime, String closingTime, String day) {
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.day = day;
    }

    public Schedules(int id, String openingTime, String closingTime, String day) {
        this.id = id;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.day = day;
    }

    public Schedules(int id, String openingTime, String closingTime, String day, List<Departments> departments) {
        this.id = id;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.day = day;
        this.departments = departments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public String getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public List<Departments> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Departments> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "\n id: " + getId() +  "\n " + "day: " + getDay() + "\n " + "openingTime: " + getOpeningTime()
                + "\n " + "closingTime: " + getClosingTime();
    }
}

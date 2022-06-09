package com.solvd.bank.jackson;

public class Schedule {
    private int id;
    private String openingTime;
    private String closingTime;
    private String day;

    public Schedule() {
    }

    public Schedule(int id, String openingTime, String closingTime, String day) {
        this.id = id;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.day = day;
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

    @Override
    public String toString() {
        return "\n id: " + getId() +  "\n " + "day: " + getDay() + "\n " + "openingTime: " + getOpeningTime()
                + "\n " + "closingTime: " + getClosingTime();
    }
}

package com.solvd.bank.jaxb;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
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
    @XmlAttribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    @XmlElement
    public String getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }

    @XmlElement
    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}

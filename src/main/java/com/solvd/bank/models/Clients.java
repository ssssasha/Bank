package com.solvd.bank.models;

import com.solvd.bank.patterns.listener.ActionListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Clients implements ActionListener {
    private final static Logger LOGGER = LogManager.getLogger(Clients.class);
    private int id;
    private String name;
    private String surname;
    private int age;
    private Addresses address;
    private List<Cards> cards;
    private List<Deposits> deposits;
    private List<Credits> credits;
    private List<Accounts> accounts;

    public Clients() {
    }

    public Clients(String name, String surname, int age, Addresses address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public Clients(int id, String name, String surname, int age, Addresses address, List<Cards> cards,
                   List<Deposits> deposits, List<Credits> credits, List<Accounts> accounts) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
        this.cards = cards;
        this.deposits = deposits;
        this.credits = credits;
        this.accounts = accounts;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Addresses getAddress() {
        return address;
    }

    public void setAddress(Addresses address) {
        this.address = address;
    }

    public List<Cards> getCards() {
        return cards;
    }

    public void setCards(List<Cards> cards) {
        this.cards = cards;
    }

    public List<Deposits> getDeposits() {
        return deposits;
    }

    public void setDeposits(List<Deposits> deposits) {
        this.deposits = deposits;
    }

    public List<Credits> getCredits() {
        return credits;
    }

    public void setCredits(List<Credits> credits) {
        this.credits = credits;
    }

    public List<Accounts> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Accounts> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "\n id: " + getId()+ "\n " + "name: " + getName() + "\n " + "surname: " + getSurname()
                + "\n " + "age: " + getAge() + "\n\n " + "address: " + getAddress();
    }

    @Override
    public void doSomeAction() {
        LOGGER.info("Welcome to bank " + this.name + " " + this.surname + "!");
        if (this.age <18) LOGGER.info("Unfortunately, we don't provide services for underage clients");
        if (this.age >=18) LOGGER.info("Please, choose which service you want to use");
    }
}

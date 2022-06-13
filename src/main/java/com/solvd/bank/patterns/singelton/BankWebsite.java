package com.solvd.bank.patterns.singelton;

public class BankWebsite {
    private String url = "https://privat24.ua/";
    static BankWebsite bankWebsite = new BankWebsite();

    private BankWebsite() {

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static BankWebsite getInstance() {
        return bankWebsite;
    }
}

package com.solvd.bank.patterns.absrtactFactory;

public class CreditCard implements ICard{

    @Override
    public String getCard() {
        return "credit";
    }
}

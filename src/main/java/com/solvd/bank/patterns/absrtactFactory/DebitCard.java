package com.solvd.bank.patterns.absrtactFactory;

public class DebitCard implements ICard{
    @Override
    public String getCard() {
        return "debit";
    }
}

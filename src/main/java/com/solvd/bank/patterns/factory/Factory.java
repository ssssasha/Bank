package com.solvd.bank.patterns.factory;

public class Factory {

    public IFactory getCard(String cardType){
        if(cardType == null){
            return null;
        }
        if(cardType.equalsIgnoreCase("credit")){
            return new CreditCard();
        } else if(cardType.equalsIgnoreCase("debit")) {
            return new DebitCard();
        }
        return null;
    }
}

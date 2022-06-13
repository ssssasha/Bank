package com.solvd.bank.patterns.absrtactFactory;

public class CardFactory implements AbstractFactory<ICard>{
    @Override
    public ICard create(String cardType) {
        if ("credit".equalsIgnoreCase(cardType)) {
            return new CreditCard();
        } else if ("debit".equalsIgnoreCase(cardType)) {
            return new DebitCard();
        }
        return null;
    }
}

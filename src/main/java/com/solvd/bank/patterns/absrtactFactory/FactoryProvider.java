package com.solvd.bank.patterns.absrtactFactory;

public class FactoryProvider {
    public static AbstractFactory getFactory(String choice){

        if("Bank".equalsIgnoreCase(choice)){
            return new BankFactory();
        }
        else if("Card".equalsIgnoreCase(choice)){
            return new CardFactory();
        }

        return null;
    }
}

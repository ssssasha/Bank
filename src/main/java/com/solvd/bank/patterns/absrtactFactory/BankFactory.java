package com.solvd.bank.patterns.absrtactFactory;

public class BankFactory implements AbstractFactory<IBank> {
    @Override
    public IBank create(String bankType) {
        if ("Privatbank".equalsIgnoreCase(bankType)) {
            return new Privatbank();
        } else if ("Monobank".equalsIgnoreCase(bankType)) {
            return new Monobank();
        } else if ("Ukrbank".equalsIgnoreCase(bankType)) {
            return new Ukrbank();
        }
        return null;
    }
}

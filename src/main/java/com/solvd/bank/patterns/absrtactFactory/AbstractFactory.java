package com.solvd.bank.patterns.absrtactFactory;

public interface AbstractFactory<T> {
    T create(String abstractType) ;
}

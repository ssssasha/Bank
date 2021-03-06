package com.solvd.bank.dao;

import com.solvd.bank.models.ATMs;

import java.util.List;

public interface IATMsDAO {

    ATMs getATMByID(int id);
    void createATM(ATMs atm);
    void updateATM(ATMs atm);
    void deleteATM(ATMs atm);
    List<ATMs> getATMs();
}

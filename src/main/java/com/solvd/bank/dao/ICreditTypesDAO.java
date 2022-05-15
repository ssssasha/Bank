package com.solvd.bank.dao;

import com.solvd.bank.models.CreditTypes;

import java.util.List;

public interface ICreditTypesDAO {

    CreditTypes getCreditTypeByID(int id);
    void createCreditType(CreditTypes creditType);
    void updateCreditType(CreditTypes creditType);
    void deleteCreditType(CreditTypes creditType);
    List<CreditTypes> getAllCreditTypes();
}

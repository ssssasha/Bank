package com.solvd.bank.dao;

import com.solvd.bank.models.CreditTypes;

public interface ICreditTypesDAO {

    CreditTypes getCreditTypeByID(int id);
    void createCreditType(CreditTypes creditType);
    void updateCreditType(CreditTypes creditType);
    void deleteCreditType(CreditTypes creditType);
}

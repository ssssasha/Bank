package com.solvd.bank.dao;

import com.solvd.bank.models.Banks;

public interface IBanksDAO {

    Banks getBankByID(int id);
    void createBank(Banks bank);
    void updateBank(Banks bank);
    void deleteBank(Banks bank);
}

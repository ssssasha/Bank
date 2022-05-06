package com.solvd.bank.dao;

import com.solvd.bank.models.Deposits;

public interface IDepositsDAO {

    Deposits getDepositByID(int id);
    void createDeposit(Deposits deposit);
    void updateDeposit(Deposits deposit);
    void deleteDeposit(Deposits deposit);
}

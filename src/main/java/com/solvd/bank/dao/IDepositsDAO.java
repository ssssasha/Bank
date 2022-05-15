package com.solvd.bank.dao;

import com.solvd.bank.models.Deposits;

import java.util.List;

public interface IDepositsDAO {

    Deposits getDepositByID(int id);
    void createDeposit(Deposits deposit);
    void updateDeposit(Deposits deposit);
    void deleteDeposit(Deposits deposit);
    List<Deposits> getDeposits(int minimumContribution, int term);
}

package com.solvd.bank.dao;

import com.solvd.bank.models.Accounts;

import java.util.List;

public interface IAccountsDAO {

    Accounts getAccountByID(int id);
    void createAccount(Accounts account);
    void updateAccount(Accounts account);
    void deleteAccount(Accounts account);
    List<Accounts> getAccountByClientId(int clientId);
}

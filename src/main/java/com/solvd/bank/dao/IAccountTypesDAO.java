package com.solvd.bank.dao;

import com.solvd.bank.models.AccountTypes;

public interface IAccountTypesDAO {

    AccountTypes getAccountTypeByID(int id);
    void createAccountType(AccountTypes accountType);
    void updateAccountType(AccountTypes accountType);
    void deleteAccountType(AccountTypes accountType);
}

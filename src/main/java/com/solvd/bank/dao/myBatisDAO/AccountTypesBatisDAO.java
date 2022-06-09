package com.solvd.bank.dao.myBatisDAO;

import com.solvd.bank.dao.IAccountTypesDAO;
import com.solvd.bank.models.AccountTypes;

import java.util.List;

public class AccountTypesBatisDAO extends AbstractDAO<IAccountTypesDAO> implements IAccountTypesDAO {

    @Override
    public AccountTypes getAccountTypeByID(int id) {
        setMapper();
        AccountTypes accountType = mapper.getAccountTypeByID(id);
        closeSession();
        return accountType;
    }

    @Override
    public void createAccountType(AccountTypes accountType) {
        setMapper();
        mapper.createAccountType(accountType);
        session.commit();
        closeSession();
    }

    @Override
    public void updateAccountType(AccountTypes accountType) {
        setMapper();
        mapper.updateAccountType(accountType);
        session.commit();
        closeSession();
    }

    @Override
    public void deleteAccountType(AccountTypes accountType) {
        setMapper();
        mapper.deleteAccountType(accountType);
        session.commit();
        closeSession();
    }

    @Override
    public List<AccountTypes> getAllAccountTypes() {
        setMapper();
        List<AccountTypes> accountTypes = mapper.getAllAccountTypes();
        closeSession();
        return accountTypes;
    }

    @Override
    public void setMapper() {
        openSession();
        mapper = session.getMapper(IAccountTypesDAO.class);
    }
}

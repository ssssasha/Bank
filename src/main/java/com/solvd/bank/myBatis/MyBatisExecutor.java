package com.solvd.bank.myBatis;

import com.solvd.bank.dao.myBatisDAO.AccountTypesBatisDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyBatisExecutor {

    private static final Logger LOGGER = LogManager.getLogger(MyBatisExecutor.class);

    public static void main(String[] args) {
        AccountTypesBatisDAO accountTypesBatisDAO = new AccountTypesBatisDAO();
        //LOGGER.info(accountTypesBatisDAO.getAccountTypeByID(2));
        // creating
        //AccountTypes accountTypeToAdd = new AccountTypes("new account type");
        //accountTypesBatisDAO.createAccountType(accountTypeToAdd);

        //updating

//        AccountTypes accountTypeToUpdate = accountTypesBatisDAO.getAccountTypeByID(135);
//        accountTypeToUpdate.setName("updated account type");
//        accountTypesBatisDAO.updateAccountType(accountTypeToUpdate);

        //deleting
//        AccountTypes accountTypeToDelete = accountTypesBatisDAO.getAccountTypeByID(135);
//        accountTypesBatisDAO.deleteAccountType(accountTypeToDelete);

        LOGGER.info(accountTypesBatisDAO.getAllAccountTypes());

        //CardTypesBatisDAO cardTypesBatisDAO = new CardTypesBatisDAO();
        //LOGGER.info(cardTypesBatisDAO.getCardTypeByID(1));
    }

}

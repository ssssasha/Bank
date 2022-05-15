package com.solvd.bank;

import com.solvd.bank.dao.IBanksDAO;
import com.solvd.bank.dao.ICardsDAO;
import com.solvd.bank.dao.jdbcMySQLImpl.*;
import com.solvd.bank.models.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        // creating
//        BanksDAO createBanksDAO = new BanksDAO();
//        Banks newBank = new Banks("NewBank", "+0982324428");
//        createBanksDAO.createBank(newBank);
//      reading
//        BanksDAO getBanksDAO = new BanksDAO();
//        LOGGER.info(getBanksDAO.getBankByID(1).getName());
//        //updating
//        BanksDAO updateBanksDAO = new BanksDAO();
//        Banks bankToUpdate = new Banks(1, "PrivatBank", "+0982223311");
//        updateBanksDAO.updateBank(bankToUpdate);
//        //deleting
//        BanksDAO deleteBanksDAO = new BanksDAO();
//        Banks bankToDelete = new Banks(153);
//        deleteBanksDAO.deleteBank(bankToDelete);
//
//        //getting a list of Banks
//        BanksDAO banks = new BanksDAO();
//        List<Banks> banksList;
//        banksList = banks.getBankByName("UkrBank");
//        for (Banks el : banksList){
//            LOGGER.info(el);
//        }
//
//        // creating
////        AccountsDAO createAccountsDAO = new AccountsDAO();
////        Accounts newAccount = new Accounts(1, 1,"7682324428");
////        createAccountsDAO.createAccount(newAccount);
//
//        //getting a list of Accounts by client id
//        AccountsDAO accounts = new AccountsDAO();
//        List<Accounts> accountsList;
//        accountsList = accounts.getAccountByClientId(1);
//        for (Accounts el : accountsList){
//            LOGGER.info(el);
//        }
//
//        //getting a list of all account types
//        AccountTypesDAO accountTypes = new AccountTypesDAO();
//        List<AccountTypes> accountTypesList;
//        accountTypesList= accountTypes.getAllAccountTypes();
//        for (AccountTypes el : accountTypesList){
//            LOGGER.info(el);
//        }

        //getting a list addresses with streets
//        AddressesDAO adr = new AddressesDAO();
//        List<Addresses> addressesList = new ArrayList<>();
//        addressesList = adr.getAddressWithStreets();
//        for (Addresses a: addressesList){
//            LOGGER.info(a);
//        }
//
//        //getting a list atms
//        ATMsDAO atm = new ATMsDAO();
//        List<ATMs> atmsList = new ArrayList<>();
//        atmsList = atm.getATMs();
//        for (ATMs el: atmsList){
//            LOGGER.info(el);
//        }

        // getClientsWithNullCredit
        ClientsDAO clientsDAO =new ClientsDAO();
        List<Clients> clientsList = new ArrayList<>();
        clientsList = clientsDAO.getClientsWithNullCredit();
        for (Clients el:clientsList){
            LOGGER.info("\n name: "+el.getName() + "\n surname: " + el.getSurname() + "\n id: " + el.getId());
        }

        //getCards
        ICardsDAO cardDAO = new CardsDAO();
        List<Cards> cardsList = new ArrayList<>();
        cardsList = cardDAO.getCards();
        for (Cards el: cardsList){
            LOGGER.info(el);
        }

        //getting a list of Deposits
        DepositsDAO depositsDAO = new DepositsDAO();
        List<Deposits> depositsList;
        depositsList = depositsDAO.getDeposits(30000,12);
        for (Deposits el : depositsList){
            LOGGER.info(el);
        }

        //getting a list of Schedules by day
        SchedulesDAO schedulesDAO = new SchedulesDAO();
        List<Schedules> schedulesList;
        schedulesList = schedulesDAO.getScheduleByDay("Monday");
        for (Schedules el : schedulesList){
            LOGGER.info(el);
        }


    }
}

package com.solvd.bank.patterns;

import com.solvd.bank.dao.jdbcMySQLImpl.ClientsDAO;
import com.solvd.bank.models.Addresses;
import com.solvd.bank.patterns.absrtactFactory.*;
import com.solvd.bank.patterns.builder.Address;
import com.solvd.bank.patterns.builder.AddressBuilder;
import com.solvd.bank.patterns.factory.Factory;
import com.solvd.bank.patterns.factory.IFactory;
import com.solvd.bank.patterns.singelton.BankWebsite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PatternExecutor {
    private static final Logger LOGGER = LogManager.getLogger(PatternExecutor.class);
    public static void main(String[] args) {

        //builder
//        Address address = new AddressBuilder().setCity("Kherson").setStreet("Myru2").setBuildingNumber(4).getAddress();
//        LOGGER.info(address);

        //factory
//        String card = "credit";
//        Factory factory = new Factory();
//        IFactory iFactory = factory.getCard(card);
//        iFactory.getСard();

        //abstract factory
//        AbstractFactory abstractFactory = FactoryProvider.getFactory("Bank");
//        IBank bank =(IBank) abstractFactory.create("Monobank");
//        abstractFactory = FactoryProvider.getFactory("Card");
//        ICard card =(ICard) abstractFactory.create("debit");
//        LOGGER.info("Card: " + card.getCard() + " (" + bank.getBank() + ") ");

        //singelton
//        BankWebsite website1 = BankWebsite.getInstance();
//        BankWebsite website2 = BankWebsite.getInstance();
//        website1.setUrl("https://www.monobank.ua/");
//        LOGGER.info(website2.getUrl());

        //listener
//        ClientsDAO getClientDAO = new ClientsDAO();
//        LOGGER.info(getClientDAO.getClientByID(1).getName());
//        LOGGER.info(getClientDAO.getClientByID(4).getName());

    }
}

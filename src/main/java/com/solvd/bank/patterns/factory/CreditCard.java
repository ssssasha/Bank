package com.solvd.bank.patterns.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CreditCard implements IFactory {
    private static final Logger LOGGER = LogManager.getLogger(CreditCard.class);

    @Override
    public void getСard() {
        LOGGER.info("get a credit card");
    }
}

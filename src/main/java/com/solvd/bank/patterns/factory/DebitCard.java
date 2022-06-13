package com.solvd.bank.patterns.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DebitCard implements IFactory {
    private static final Logger LOGGER = LogManager.getLogger(DebitCard.class);

    @Override
    public void getСard() {
        LOGGER.info("get a debit card");
    }
}

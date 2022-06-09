package com.solvd.bank.myBatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

public class SQLSession {
    private static final Logger LOGGER = LogManager.getLogger(SQLSession.class);
    private static SQLSession factoryInstance;
    private static SqlSessionFactory factory;

    private SQLSession(String resources) {
        try {
            InputStream inputStream = Resources.getResourceAsStream(resources);
            factory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }

    public static SQLSession newInstance(String resources) {
        if (factoryInstance == null) factoryInstance = new SQLSession(resources);
        return factoryInstance;
    }

    public SqlSessionFactory getFactory() {
        return factory;
    }
}

package com.solvd.bank.dao.myBatisDAO;

import com.solvd.bank.myBatis.SQLSession;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractDAO<T> {
    private static final Logger LOGGER = LogManager.getLogger();

    protected SqlSession session;
    protected T mapper;

    public void openSession() {
        SQLSession factory = SQLSession.newInstance("mybatis/mybatis_config.xml");
        session = factory.getFactory().openSession();
    }

    public void closeSession() {
        if (session != null) session.close();
    }

    abstract public void setMapper();
}

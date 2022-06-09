package com.solvd.bank.dao.myBatisDAO;

import com.solvd.bank.dao.ICreditTypesDAO;
import com.solvd.bank.models.CreditTypes;

import java.util.List;

public class CreditTypesBatisDAO extends AbstractDAO<ICreditTypesDAO> implements ICreditTypesDAO {

    @Override
    public CreditTypes getCreditTypeByID(int id) {
        setMapper();
        CreditTypes creditType = mapper.getCreditTypeByID(id);
        closeSession();
        return creditType;
    }

    @Override
    public void createCreditType(CreditTypes creditType) {
        setMapper();
        mapper.createCreditType(creditType);
        session.commit();
        closeSession();
    }

    @Override
    public void updateCreditType(CreditTypes creditType) {
        setMapper();
        mapper.updateCreditType(creditType);
        session.commit();
        closeSession();
    }

    @Override
    public void deleteCreditType(CreditTypes creditType) {
        setMapper();
        mapper.deleteCreditType(creditType);
        session.commit();
        closeSession();
    }

    @Override
    public List<CreditTypes> getAllCreditTypes() {
        setMapper();
        List<CreditTypes> creditTypes = mapper.getAllCreditTypes();
        closeSession();
        return creditTypes;
    }

    @Override
    public void setMapper() {
        openSession();
        mapper = session.getMapper(ICreditTypesDAO.class);
    }
}

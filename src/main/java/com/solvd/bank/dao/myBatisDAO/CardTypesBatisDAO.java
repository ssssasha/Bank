package com.solvd.bank.dao.myBatisDAO;

import com.solvd.bank.dao.ICardTypesDAO;
import com.solvd.bank.models.CardTypes;

import java.util.List;

public class CardTypesBatisDAO extends AbstractDAO<ICardTypesDAO> implements ICardTypesDAO {

    @Override
    public CardTypes getCardTypeByID(int id) {
        setMapper();
        CardTypes cardType = mapper.getCardTypeByID(id);
        closeSession();
        return cardType;
    }

    @Override
    public void createCardType(CardTypes cardType) {
        setMapper();
        mapper.createCardType(cardType);
        session.commit();
        closeSession();
    }

    @Override
    public void updateCardType(CardTypes cardType) {
        setMapper();
        mapper.updateCardType(cardType);
        session.commit();
        closeSession();
    }

    @Override
    public void deleteCardType(CardTypes cardType) {
        setMapper();
        mapper.deleteCardType(cardType);
        session.commit();
        closeSession();
    }

    @Override
    public List<CardTypes> getAllCardTypes() {
        setMapper();
        List<CardTypes> cardTypes = mapper.getAllCardTypes();
        closeSession();
        return cardTypes;
    }

    @Override
    public void setMapper() {
        openSession();
        mapper = session.getMapper(ICardTypesDAO.class);
    }
}

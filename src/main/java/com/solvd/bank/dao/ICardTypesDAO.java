package com.solvd.bank.dao;

import com.solvd.bank.models.CardTypes;

public interface ICardTypesDAO {

    CardTypes getCardTypeByID(int id);
    void createCardType(CardTypes cardType);
    void updateCardType(CardTypes cardType);
    void deleteCardType(CardTypes cardType);
}

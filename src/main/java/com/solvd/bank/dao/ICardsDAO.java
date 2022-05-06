package com.solvd.bank.dao;

import com.solvd.bank.models.Cards;

public interface ICardsDAO {

    Cards getCardByID(int id);
    void createCard(Cards card);
    void updateCard(Cards card);
    void deleteCard(Cards card);
}

package com.solvd.bank.dao;

import com.solvd.bank.models.Cards;

import java.util.List;

public interface ICardsDAO {

    Cards getCardByID(int id);
    void createCard(Cards card);
    void updateCard(Cards card);
    void deleteCard(Cards card);
    List<Cards> getCards();
}

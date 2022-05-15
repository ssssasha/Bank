package com.solvd.bank.dao;

import com.solvd.bank.models.Streets;

import java.util.List;

public interface IStreetsDAO {

    Streets getStreetByID(int id);
    void createStreet(Streets street);
    void updateStreet(Streets street);
    void deleteStreet(Streets street);
    List<Streets> getAllStreets();
}


package com.solvd.bank.dao;

import com.solvd.bank.models.Cities;

public interface ICitiesDAO {

    Cities getCityByID(int id);
    void createCity(Cities city);
    void updateCity(Cities city);
    void deleteCity(Cities city);
}

package com.solvd.bank.dao;

import com.solvd.bank.models.Cities;

import java.util.List;

public interface ICitiesDAO {

    Cities getCityByID(int id);
    void createCity(Cities city);
    void updateCity(Cities city);
    void deleteCity(Cities city);
    List<Cities> getAllCities();
}

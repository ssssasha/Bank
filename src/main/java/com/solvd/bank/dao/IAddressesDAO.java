package com.solvd.bank.dao;

import com.solvd.bank.models.Addresses;

import java.util.List;

public interface IAddressesDAO {

    Addresses getAddressByID(int id);
    void createAddress(Addresses address);
    void updateAddress(Addresses address);
    void deleteAddress(Addresses address);
    List<Addresses> getAddressWithStreets();
}

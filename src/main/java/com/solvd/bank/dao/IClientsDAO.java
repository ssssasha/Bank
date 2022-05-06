package com.solvd.bank.dao;

import com.solvd.bank.models.Clients;

public interface IClientsDAO {

    Clients getClientByID(int id);
    void createClient(Clients client);
    void updateClient(Clients client);
    void deleteClient(Clients client);
}

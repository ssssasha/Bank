package com.solvd.bank.dao;

import com.solvd.bank.models.Credits;

public interface ICreditsDAO {

    Credits getCreditByID(int id);
    void createCredit(Credits credit);
    void updateCredit(Credits credit);
    void deleteCredit(Credits credit);
}

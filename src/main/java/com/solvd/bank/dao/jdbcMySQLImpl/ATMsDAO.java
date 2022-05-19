package com.solvd.bank.dao.jdbcMySQLImpl;

import com.solvd.bank.dao.IATMsDAO;
import com.solvd.bank.models.ATMs;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ATMsDAO extends AbstractDAO implements IATMsDAO {

    private static final Logger LOGGER = LogManager.getLogger(ATMsDAO.class);

    public ATMs getATMByID(int id) {
        ATMs atm = new ATMs();
        try {
            PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM atms WHERE id = ?");
            statement.setInt(1,id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    atm.setId(resultSet.getInt("id"));
                    atm.setBank(new BanksDAO().getBankByID(resultSet.getInt("bankId")));
                    atm.setAddress(new AddressesDAO().getAddressByID(resultSet.getInt("addressId")));
                }
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally {
            closeAll();
        }return atm;
    }

    public void createATM(ATMs atm) {
        try {
            PreparedStatement statement = getConnection().prepareStatement("INSERT INTO " +
                    "atms (bankId,addressId) VALUES (?,?)");
            statement.setInt(1, atm.getBank().getId());
            statement.setInt(2, atm.getAddress().getId());
            int st = statement.executeUpdate();
            LOGGER.info(st + " records inserted");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public void updateATM(ATMs atm) {
        try {
            PreparedStatement statement = getConnection().prepareStatement("UPDATE atms SET bankId = ?, addressId = ? " +
                    "WHERE id = ?");
            statement.setInt(1, atm.getBank().getId());
            statement.setInt(2, atm.getAddress().getId());
            statement.setInt(3, atm.getId());
            statement.executeUpdate();
            LOGGER.info("Successfully updated");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public void deleteATM(ATMs atm) {
        try{
            PreparedStatement statement = getConnection().prepareStatement("DELETE FROM atms WHERE id = ?");
            statement.setInt(1, atm.getId());
            statement.execute();
            LOGGER.info("Successfully deleted");
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public List<ATMs> getATMs(){
        List<ATMs> atmsList  = new ArrayList<>();
        try {
            PreparedStatement statement = getConnection().prepareStatement("SELECT atms.id, banks.id FROM atms INNER JOIN addresses ON addresses.id = atms.addressId INNER JOIN banks ON banks.id = atms.bankId WHERE banks.name IN ('Ukrbank', 'Monobank', 'Alfabank') AND addresses.id BETWEEN 2 AND 5");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                ATMs atm = new ATMs();
                atm.setId(resultSet.getInt("id"));
                atm.setBank(new BanksDAO().getBankByID(resultSet.getInt("banks.id")));
                atmsList.add(atm);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally{
            closeAll();
        }return atmsList;
    }
}

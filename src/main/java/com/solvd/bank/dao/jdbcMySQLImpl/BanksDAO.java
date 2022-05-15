package com.solvd.bank.dao.jdbcMySQLImpl;

import com.solvd.bank.DBConnection;
import com.solvd.bank.dao.IBanksDAO;
import com.solvd.bank.models.Banks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BanksDAO extends AbstractDAO implements IBanksDAO {

    private static final Logger LOGGER = LogManager.getLogger(BanksDAO.class);

    public Banks getBankByID(int id) {
        Banks bank = new Banks();
        try {
            PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM banks WHERE id = ?");
            statement.setInt(1,id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    bank.setId(resultSet.getInt("id"));
                    bank.setName(resultSet.getString("name"));
                    bank.setPhoneNumber(resultSet.getString("phoneNumber"));
                }
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally {
            closeAll();
        }return bank;
    }

    public void createBank(Banks bank) {
        try {
            PreparedStatement statement = getConnection().prepareStatement("INSERT INTO " +
                    "banks (name,phoneNumber) VALUES (?,?)");
            statement.setString(1, bank.getName());
            statement.setString(2, bank.getPhoneNumber());
            int st = statement.executeUpdate();
            LOGGER.info(st + " records inserted");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public void updateBank(Banks bank) {
        try {
            PreparedStatement statement = getConnection().prepareStatement("UPDATE banks SET name = ?, phoneNumber = ? WHERE id = ?");
            statement.setString(1, bank.getName());
            statement.setString(2, bank.getPhoneNumber());
            statement.setInt(3, bank.getId());
            statement.executeUpdate();
            LOGGER.info("Successfully updated");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public void deleteBank(Banks bank) {
        try{
            PreparedStatement statement = getConnection().prepareStatement("DELETE FROM banks WHERE id = ?");
            statement.setInt(1, bank.getId());
            statement.execute();
            LOGGER.info("Successfully deleted");
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public List<Banks> getBankByName(String name){
        List<Banks> bankList  = new ArrayList<>();
        try {
            PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM banks WHERE banks.name = ?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Banks bank = new Banks();
                bank.setId(resultSet.getInt("id"));
                bank.setName(resultSet.getString("name"));
                bank.setPhoneNumber(resultSet.getString("phoneNumber"));
                bankList.add(bank);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally{
            closeAll();
        }return bankList;
    }
}

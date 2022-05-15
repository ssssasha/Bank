package com.solvd.bank.dao.jdbcMySQLImpl;

import com.solvd.bank.dao.IAccountsDAO;
import com.solvd.bank.models.Accounts;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.sql.*;

public class AccountsDAO extends  AbstractDAO implements IAccountsDAO {

    private static final Logger LOGGER = LogManager.getLogger(AccountsDAO.class);

    public Accounts getAccountByID(int id) {
        Accounts account = new Accounts();
        try {
            PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM accounts WHERE id = ?");
            statement.setInt(1,id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    account.setId(resultSet.getInt("id"));
                    account.setClientId(resultSet.getInt("clientId"));
                    account.setAccountTypeId(resultSet.getInt("accountTypeId"));
                    account.setNumber(resultSet.getString("number"));
                }
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally {
            closeAll();
        }return account;
    }

    public void createAccount(Accounts account) {
        try {
            PreparedStatement statement = getConnection().prepareStatement("INSERT INTO " +
                    "accounts (clientId,accountTypeId,number) VALUES (?,?,?)");
            statement.setInt(1, account.getClientId());
            statement.setInt(2, account.getAccountTypeId());
            statement.setString(3, account.getNumber());
            int st = statement.executeUpdate();
            LOGGER.info(st + " records inserted");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public void updateAccount(Accounts account) {
        try {
            PreparedStatement statement = getConnection().prepareStatement("UPDATE accounts " +
                    "SET clientId = ?, accountTypeId = ?, number = ? WHERE id = ?");
            statement.setInt(1, account.getClientId());
            statement.setInt(2, account.getAccountTypeId());
            statement.setString(3, account.getNumber());
            statement.setInt(4, account.getId());
            statement.executeUpdate();
            LOGGER.info("Successfully updated");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public void deleteAccount(Accounts account) {
        try{
            PreparedStatement statement = getConnection().prepareStatement("DELETE FROM accounts WHERE id = ?");
            statement.setInt(1, account.getId());
            statement.execute();
            LOGGER.info("Successfully deleted");
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public List<Accounts> getAccountByClientId(int clientId){
        List<Accounts> accountsList  = new ArrayList<>();
        try {
            PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM accounts WHERE clientId = ?");
            statement.setInt(1, clientId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Accounts account = new Accounts();
                account.setId(resultSet.getInt("id"));
                account.setClientId(resultSet.getInt("clientId"));
                account.setAccountTypeId(resultSet.getInt("accountTypeId"));
                account.setNumber(resultSet.getString("number"));
                accountsList.add(account);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally{
            closeAll();
        }return accountsList;
    }
}

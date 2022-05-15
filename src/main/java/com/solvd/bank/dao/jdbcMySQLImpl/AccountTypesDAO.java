package com.solvd.bank.dao.jdbcMySQLImpl;

import com.solvd.bank.dao.IAccountTypesDAO;
import com.solvd.bank.models.AccountTypes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountTypesDAO extends AbstractDAO implements IAccountTypesDAO {

    private static final Logger LOGGER = LogManager.getLogger(AccountTypesDAO.class);

    public AccountTypes getAccountTypeByID(int id) {
        AccountTypes accountType = new AccountTypes();
        try {
            PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM accounttypes WHERE id = ?");
            statement.setInt(1,id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    accountType.setId(resultSet.getInt("id"));
                    accountType.setName(resultSet.getString("name"));
                }
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally {
            closeAll();
        }return accountType;
    }

    public void createAccountType(AccountTypes accountType) {
        try {
            PreparedStatement statement = getConnection().prepareStatement("INSERT INTO " +
                    "accounttypes (name) VALUES (?)");
            statement.setString(1, accountType.getName());
            int st = statement.executeUpdate();
            LOGGER.info(st + " records inserted");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public void updateAccountType(AccountTypes accountType) {
        try {
            PreparedStatement statement = getConnection().prepareStatement("UPDATE accounttypes " +
                    "SET name = ? WHERE id = ?");
            statement.setString(1, accountType.getName());
            statement.setInt(2, accountType.getId());
            statement.executeUpdate();
            LOGGER.info("Successfully updated");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public void deleteAccountType(AccountTypes accountType) {
        try{
            PreparedStatement statement = getConnection().prepareStatement("DELETE FROM accounttypes WHERE id = ?");
            statement.setInt(1, accountType.getId());
            statement.execute();
            LOGGER.info("Successfully deleted");
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }
    public List<AccountTypes> getAllAccountTypes() {
        List<AccountTypes> accountTypes = new ArrayList<>();
        try {
            resultSet = getResultSet("SELECT * FROM accounttypes");
            while (resultSet.next()) {
                AccountTypes accountType = new AccountTypes();
                accountType.setId(resultSet.getInt("id"));
                accountType.setName(resultSet.getString("name"));
                accountTypes.add(accountType);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return accountTypes;
    }
}

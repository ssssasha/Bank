package com.solvd.bank.dao.jdbcMySQLImpl;

import com.solvd.bank.dao.ICreditTypesDAO;
import com.solvd.bank.dao.ICreditsDAO;
import com.solvd.bank.models.AccountTypes;
import com.solvd.bank.models.Cards;
import com.solvd.bank.models.CreditTypes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CreditTypesDAO extends AbstractDAO implements ICreditTypesDAO {

    private static final Logger LOGGER = LogManager.getLogger(CreditTypesDAO.class);

    public CreditTypes getCreditTypeByID(int id) {
        CreditTypes creditType = new CreditTypes();
        try {
            PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM credittypes WHERE id = ?");
            statement.setInt(1,id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    creditType.setId(resultSet.getInt("id"));
                    creditType.setName(resultSet.getString("name"));
                }
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally {
            closeAll();
        }return creditType;
    }

    public void createCreditType(CreditTypes creditType) {
        try {
            PreparedStatement statement = getConnection().prepareStatement("INSERT INTO " +
                    "credittypes (name) VALUES (?)");
            statement.setString(1, creditType.getName());
            int st = statement.executeUpdate();
            LOGGER.info(st + " records inserted");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public void updateCreditType(CreditTypes creditType) {
        try {
            PreparedStatement statement = getConnection().prepareStatement("UPDATE credittypes SET name = ? WHERE id = ?");
            statement.setString(1, creditType.getName());
            statement.setInt(2, creditType.getId());
            statement.executeUpdate();
            LOGGER.info("Successfully updated");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public void deleteCreditType(CreditTypes creditType) {
        try{
            PreparedStatement statement = getConnection().prepareStatement("DELETE FROM credittypes WHERE id = ?");
            statement.setInt(1, creditType.getId());
            statement.execute();
            LOGGER.info("Successfully deleted");
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public List<CreditTypes> getAllCreditTypes() {
        List<CreditTypes> creditTypesList = new ArrayList<>();
        try {
            resultSet = getResultSet("SELECT * FROM credittypes");
            while (resultSet.next()) {
                CreditTypes creditType = new CreditTypes();
                creditType.setId(resultSet.getInt("id"));
                creditType.setName(resultSet.getString("name"));
                creditTypesList.add(creditType);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return creditTypesList;
    }
}

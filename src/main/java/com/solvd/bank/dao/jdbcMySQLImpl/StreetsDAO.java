package com.solvd.bank.dao.jdbcMySQLImpl;

import com.solvd.bank.dao.IStreetsDAO;
import com.solvd.bank.models.AccountTypes;
import com.solvd.bank.models.Streets;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StreetsDAO extends AbstractDAO implements IStreetsDAO {

    private static final Logger LOGGER = LogManager.getLogger(StreetsDAO.class);

    public Streets getStreetByID(int id) {
        Streets street = new Streets();
        try {
            PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM streets WHERE id = ?");
            statement.setInt(1,id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    street.setId(resultSet.getInt("id"));
                    street.setName(resultSet.getString("name"));
                }
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally {
            closeAll();
        }return street;
    }

    public void createStreet(Streets street) {
        try {
            PreparedStatement statement = getConnection().prepareStatement("INSERT INTO " +
                    "streets (name) VALUES (?)");
            statement.setString(1, street.getName());
            int st = statement.executeUpdate();
            LOGGER.info(st + " records inserted");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public void updateStreet(Streets street) {
        try {
            PreparedStatement statement = getConnection().prepareStatement("UPDATE streets SET name = ? WHERE id = ?");
            statement.setString(1, street.getName());
            statement.setInt(2, street.getId());
            statement.executeUpdate();
            LOGGER.info("Successfully updated");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public void deleteStreet(Streets street) {
        try{
            PreparedStatement statement = getConnection().prepareStatement("DELETE FROM streets WHERE id = ?");
            statement.setInt(1, street.getId());
            statement.execute();
            LOGGER.info("Successfully deleted");
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public List<Streets> getAllStreets() {
        List<Streets> streetsList = new ArrayList<>();
        try {
            resultSet = getResultSet("SELECT * FROM Streets");
            while (resultSet.next()) {
                Streets street = new Streets();
                street.setId(resultSet.getInt("id"));
                street.setName(resultSet.getString("name"));
                streetsList.add(street);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return streetsList;
    }
}

package com.solvd.bank.dao.jdbcMySQLImpl;

import com.solvd.bank.dao.ICitiesDAO;
import com.solvd.bank.models.AccountTypes;
import com.solvd.bank.models.Banks;
import com.solvd.bank.models.Cities;
import com.solvd.bank.models.Streets;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CitiesDAO extends AbstractDAO implements ICitiesDAO {

    private static final Logger LOGGER = LogManager.getLogger(CitiesDAO.class);

    public Cities getCityByID(int id) {
        Cities city = new Cities();
        try {
            PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM cities WHERE id = ?");
            statement.setInt(1,id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    city.setId(resultSet.getInt("id"));
                    city.setName(resultSet.getString("name"));
                }
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally {
            closeAll();
        }return city;
    }

    public void createCity(Cities city) {
        try {
            PreparedStatement statement = getConnection().prepareStatement("INSERT INTO " +
                    "cities (name) VALUES (?)");
            statement.setString(1, city.getName());
            int st = statement.executeUpdate();
            LOGGER.info(st + " records inserted");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public void updateCity(Cities city) {
        try {
            PreparedStatement statement = getConnection().prepareStatement("UPDATE cities SET name = ? WHERE id = ?");
            statement.setString(1, city.getName());
            statement.setInt(2, city.getId());
            statement.executeUpdate();
            LOGGER.info("Successfully updated");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public void deleteCity(Cities city) {
        try{
            PreparedStatement statement = getConnection().prepareStatement("DELETE FROM cities WHERE id = ?");
            statement.setInt(1, city.getId());
            statement.execute();
            LOGGER.info("Successfully deleted");
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public List<Cities> getAllCities() {
        List<Cities> citiesList = new ArrayList<>();
        try {
            resultSet = getResultSet("SELECT * FROM cities");
            while (resultSet.next()) {
                Cities city = new Cities();
                city.setId(resultSet.getInt("id"));
                city.setName(resultSet.getString("name"));
                citiesList.add(city);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return citiesList;
    }
}

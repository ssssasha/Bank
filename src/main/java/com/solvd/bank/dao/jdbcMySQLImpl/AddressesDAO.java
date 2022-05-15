package com.solvd.bank.dao.jdbcMySQLImpl;

import com.solvd.bank.dao.IAddressesDAO;
import com.solvd.bank.models.Addresses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressesDAO extends AbstractDAO implements IAddressesDAO {
    private static final Logger LOGGER = LogManager.getLogger(AddressesDAO.class);

    public Addresses getAddressByID(int id) {
        Addresses address = new Addresses();
        try {
            PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM addresses WHERE id = ?");
            statement.setInt(1,id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    address.setId(resultSet.getInt("id"));
                    address.setCityId(resultSet.getInt("cityId"));
                    address.setStreetId(resultSet.getInt("streetId"));
                    address.setBuildingNumber(resultSet.getInt("buildingNumber"));
                }
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally {
            closeAll();
        }return address;
    }

    public void createAddress(Addresses address) {
        try {
            PreparedStatement statement = getConnection().prepareStatement("INSERT INTO " +
                    "addresses (cityId,streetId,buildingNumber) VALUES (?,?,?)");
            statement.setInt(1, address.getCityId());
            statement.setInt(2, address.getStreetId());
            statement.setInt(3, address.getBuildingNumber());
            int st = statement.executeUpdate();
            LOGGER.info(st + " records inserted");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public void updateAddress(Addresses address) {
        try {
            PreparedStatement statement = getConnection().prepareStatement("UPDATE addresses SET cityId = ?, " +
                    "streetId = ?, buildingNumber = ? WHERE id = ?");
            statement.setInt(1, address.getCityId());
            statement.setInt(2, address.getStreetId());
            statement.setInt(3, address.getBuildingNumber());
            statement.setInt(4, address.getId());
            statement.executeUpdate();
            LOGGER.info("Successfully updated");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public void deleteAddress(Addresses address) {
        try{
            PreparedStatement statement = getConnection().prepareStatement("DELETE FROM addresses WHERE id = ?");
            statement.setInt(1, address.getId());
            statement.execute();
            LOGGER.info("Successfully deleted");
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public List<Addresses> getAddressWithStreets(){
        List<Addresses> addressesList = new ArrayList<>();
        try {
            PreparedStatement statement = getConnection().prepareStatement("SELECT addresses.id, streets.id FROM addresses RIGHT OUTER JOIN streets ON streets.id = addresses.streetId WHERE addresses.id IS NULL ORDER BY addresses.id DESC");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Addresses address = new Addresses();
                address.setId(resultSet.getInt("addresses.id"));
                address.setStreetId(resultSet.getInt("streets.id"));
                addressesList.add(address);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally{
            closeAll();
        }return addressesList;
    }
}

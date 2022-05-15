package com.solvd.bank.dao.jdbcMySQLImpl;

import com.solvd.bank.dao.IClientsDAO;
import com.solvd.bank.models.ATMs;
import com.solvd.bank.models.Banks;
import com.solvd.bank.models.Clients;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientsDAO extends AbstractDAO implements IClientsDAO {

    private static final Logger LOGGER = LogManager.getLogger(ClientsDAO.class);

    public Clients getClientByID(int id) {
        Clients client = new Clients();
        try {
            PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM clients WHERE id = ?");
            statement.setInt(1,id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    client.setId(resultSet.getInt("id"));
                    client.setName(resultSet.getString("name"));
                    client.setSurname(resultSet.getString("surname"));
                    client.setAge(resultSet.getInt("age"));
                    client.setAddressId(resultSet.getInt("addressId"));
                }
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally {
            closeAll();
        }return client;
    }

    public void createClient(Clients client) {
        try {
            PreparedStatement statement = getConnection().prepareStatement("INSERT INTO " +
                    "clients (name,surname,age,addressId) VALUES (?,?,?,?)");
            statement.setString(1, client.getName());
            statement.setString(2, client.getSurname());
            statement.setInt(3, client.getAge());
            statement.setInt(4, client.getAddressId());
            int st = statement.executeUpdate();
            LOGGER.info(st + " records inserted");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public void updateClient(Clients client) {
        try {
            PreparedStatement statement = getConnection().prepareStatement("UPDATE clients SET name = ?, surname = ?, age = ?, addressId = ? WHERE id = ?");
            statement.setString(1, client.getName());
            statement.setString(2, client.getSurname());
            statement.setInt(3, client.getAddressId());
            statement.setInt(4, client.getId());
            statement.executeUpdate();
            LOGGER.info("Successfully updated");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public void deleteClient(Clients client) {
        try{
            PreparedStatement statement = getConnection().prepareStatement("DELETE FROM clients WHERE id = ?");
            statement.setInt(1, client.getId());
            statement.execute();
            LOGGER.info("Successfully deleted");
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public List<Clients> getClientsWithNullCredit(){
        List<Clients> clientsList  = new ArrayList<>();
        try {
            PreparedStatement statement = getConnection().prepareStatement("SELECT clients.name, clients.surname, credits.id FROM credits RIGHT OUTER JOIN clients ON clients.id = credits.clientId WHERE credits.id IS NULL;");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Clients client = new Clients();
                client.setName(resultSet.getString("clients.name"));
                client.setSurname(resultSet.getString("clients.surname"));
                client.setId(resultSet.getInt("credits.id"));
                clientsList.add(client);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally{
            closeAll();
        }return clientsList;
    }
}

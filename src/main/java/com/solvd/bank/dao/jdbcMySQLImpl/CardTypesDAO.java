package com.solvd.bank.dao.jdbcMySQLImpl;


import com.solvd.bank.dao.ICardTypesDAO;
import com.solvd.bank.models.AccountTypes;
import com.solvd.bank.models.Banks;
import com.solvd.bank.models.CardTypes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardTypesDAO extends  AbstractDAO implements ICardTypesDAO {

    private static final Logger LOGGER = LogManager.getLogger(CardTypesDAO.class);

    public CardTypes getCardTypeByID(int id) {
        CardTypes cardType = new CardTypes();
        try {
            PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM cardtypes WHERE id = ?");
            statement.setInt(1,id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    cardType.setId(resultSet.getInt("id"));
                    cardType.setName(resultSet.getString("name"));
                }
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally {
            closeAll();
        }return cardType;
    }

    public void createCardType(CardTypes cardType) {
        try {
            PreparedStatement statement = getConnection().prepareStatement("INSERT INTO " +
                    "cardtypes (name) VALUES (?)");
            statement.setString(1, cardType.getName());
            int st = statement.executeUpdate();
            LOGGER.info(st + " records inserted");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public void updateCardType(CardTypes cardType) {
        try {
            PreparedStatement statement = getConnection().prepareStatement("UPDATE cardtypes SET name = ? WHERE id = ?");
            statement.setString(1, cardType.getName());
            statement.setInt(2, cardType.getId());
            statement.executeUpdate();
            LOGGER.info("Successfully updated");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public void deleteCardType(CardTypes cardType) {
        try{
            PreparedStatement statement = getConnection().prepareStatement("DELETE FROM cardtypes WHERE id = ?");
            statement.setInt(1, cardType.getId());
            statement.execute();
            LOGGER.info("Successfully deleted");
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public List<CardTypes> getAllCardTypes() {
        List<CardTypes> cardTypesList = new ArrayList<>();
        try {
            resultSet = getResultSet("SELECT * FROM cardtypes");
            while (resultSet.next()) {
                CardTypes cardType = new CardTypes();
                cardType.setId(resultSet.getInt("id"));
                cardType.setName(resultSet.getString("name"));
                cardTypesList.add(cardType);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cardTypesList;
    }
}

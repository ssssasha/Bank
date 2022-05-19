package com.solvd.bank.dao.jdbcMySQLImpl;

import com.solvd.bank.dao.ICardsDAO;
import com.solvd.bank.models.CardTypes;
import com.solvd.bank.models.Cards;
import com.solvd.bank.models.Clients;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardsDAO extends  AbstractDAO implements ICardsDAO {

    private static final Logger LOGGER = LogManager.getLogger(CardsDAO.class);

    public Cards getCardByID(int id) {
        Cards card = new Cards();
        try {
            PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM cards WHERE id = ?");
            statement.setInt(1,id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    card.setId(resultSet.getInt("id"));
                    card.setCardType(new CardTypesDAO().getCardTypeByID(resultSet.getInt("cardTypeId")));
                    card.setClient(new ClientsDAO().getClientByID(resultSet.getInt("clientId")));
                    card.setNumber(resultSet.getString("number"));
                }
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally {
            closeAll();
        }return card;
    }

    public void createCard(Cards card) {
        try {
            PreparedStatement statement = getConnection().prepareStatement("INSERT INTO " +
                    "cards (cardTypeId,clientId,number) VALUES (?,?,?)");
            statement.setInt(1, card.getCardType().getId());
            statement.setInt(2, card.getClient().getId());
            statement.setString(3, card.getNumber());
            int st = statement.executeUpdate();
            LOGGER.info(st + " records inserted");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public void updateCard(Cards card) {
        try {
            PreparedStatement statement = getConnection().prepareStatement("UPDATE cards SET cardTypeId = ?, clientId = ?, number = ? WHERE id = ?");
            statement.setInt(1, card.getCardType().getId());
            statement.setInt(2, card.getClient().getId());
            statement.setString(3, card.getNumber());
            statement.setInt(4, card.getId());
            statement.executeUpdate();
            LOGGER.info("Successfully updated");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public void deleteCard(Cards card) {
        try{
            PreparedStatement statement = getConnection().prepareStatement("DELETE FROM cards WHERE id = ?");
            statement.setInt(1, card.getId());
            statement.execute();
            LOGGER.info("Successfully deleted");
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public List<Cards> getCards(){
        List<Cards> cardsList  = new ArrayList<>();
        try {
            PreparedStatement statement = getConnection().prepareStatement("SELECT cards.id, cards.cardTypeId, cards.clientId, cards.number FROM cards RIGHT JOIN clients ON clients.id = cards.clientId WHERE clients.age BETWEEN 30 AND 40");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Cards card = new Cards();
                card.setId(resultSet.getInt("cards.id"));
                card.setCardType(new CardTypesDAO().getCardTypeByID(resultSet.getInt("cards.cardTypeId")));
                card.setClient(new ClientsDAO().getClientByID(resultSet.getInt("cards.clientId")));
                card.setNumber(resultSet.getString("cards.number"));
                cardsList.add(card);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally{
            closeAll();
        }return cardsList;
    }

}

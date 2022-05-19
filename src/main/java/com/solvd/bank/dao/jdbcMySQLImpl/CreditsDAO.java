package com.solvd.bank.dao.jdbcMySQLImpl;

import com.solvd.bank.dao.ICreditsDAO;
import com.solvd.bank.models.Banks;
import com.solvd.bank.models.Cards;
import com.solvd.bank.models.CreditTypes;
import com.solvd.bank.models.Credits;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CreditsDAO extends  AbstractDAO implements ICreditsDAO {

    private static final Logger LOGGER = LogManager.getLogger(BanksDAO.class);

    public Credits getCreditByID(int id) {
        Credits credit = new Credits();
        try {
            PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM credits WHERE id = ?");
            statement.setInt(1,id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    credit.setId(resultSet.getInt("id"));
                    credit.setClient(new ClientsDAO().getClientByID(resultSet.getInt("clientId")));
                    credit.setBank(new BanksDAO().getBankByID(resultSet.getInt("bankId")));
                    credit.setCreditType(new CreditTypesDAO().getCreditTypeByID(resultSet.getInt("creditTypeId")));
                    credit.setRate(resultSet.getDouble("rate"));
                    credit.setTerm(resultSet.getInt("term"));
                    credit.setMaximumAmount(resultSet.getInt("maximumAmount"));
                }
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally {
            closeAll();
        }return credit;
    }

    public void createCredit(Credits credit) {
        try {
            PreparedStatement statement = getConnection().prepareStatement("INSERT INTO " +
                    "credits (clientId,bankId,creditTypeId,rate,term,maximumAmount) VALUES (?,?,?,?,?,?)");
            statement.setInt(1, credit.getClient().getId());
            statement.setInt(2, credit.getBank().getId());
            statement.setInt(3, credit.getCreditType().getId());
            statement.setDouble(4, credit.getRate());
            statement.setInt(5, credit.getTerm());
            statement.setInt(6, credit.getMaximumAmount());
            int st = statement.executeUpdate();
            LOGGER.info(st + " records inserted");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public void updateCredit(Credits credit) {
        try {
            PreparedStatement statement = getConnection().prepareStatement("UPDATE credits SET clientId = ?, bankId = ?, creditTypeId = ?,rate = ?,term = ?,maximumAmount = ? WHERE id = ?");
            statement.setInt(1, credit.getClient().getId());
            statement.setInt(2, credit.getBank().getId());
            statement.setInt(3, credit.getCreditType().getId());
            statement.setDouble(4, credit.getRate());
            statement.setInt(5, credit.getTerm());
            statement.setInt(6, credit.getMaximumAmount());
            statement.setInt(7, credit.getId());

            statement.executeUpdate();
            LOGGER.info("Successfully updated");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public void deleteCredit(Credits credit) {
        try{
            PreparedStatement statement = getConnection().prepareStatement("DELETE FROM credits WHERE id = ?");
            statement.setInt(1, credit.getId());
            statement.execute();
            LOGGER.info("Successfully deleted");
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public List<Credits> getCreditsByTerm(){
        List<Credits> creditsList  = new ArrayList<>();
        try {
            PreparedStatement statement = getConnection().prepareStatement("SELECT id, term FROM credits WHERE term >12");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Credits credit = new Credits();
                credit.setId(resultSet.getInt("id"));
                credit.setTerm(resultSet.getInt("term"));
                creditsList.add(credit);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally{
            closeAll();
        }return creditsList;
    }
}

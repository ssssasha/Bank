package com.solvd.bank.dao.jdbcMySQLImpl;

import com.solvd.bank.dao.IDepositsDAO;
import com.solvd.bank.models.Accounts;
import com.solvd.bank.models.Banks;
import com.solvd.bank.models.Deposits;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepositsDAO extends AbstractDAO implements IDepositsDAO {

    private static final Logger LOGGER = LogManager.getLogger(DepositsDAO.class);

    public Deposits getDepositByID(int id) {
        Deposits deposit = new Deposits();
        try {
            PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM deposits WHERE id = ?");
            statement.setInt(1,id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    deposit.setId(resultSet.getInt("id"));
                    deposit.setClient(new ClientsDAO().getClientByID(resultSet.getInt("clientId")));
                    deposit.setBank(new BanksDAO().getBankByID(resultSet.getInt("bankId")));
                    deposit.setMinimumContribution(resultSet.getInt("minimumContribution"));
                    deposit.setPercentagePerAnnum(resultSet.getInt("percentagePerAnnum"));
                    deposit.setTerm(resultSet.getInt("term"));
                }
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally {
            closeAll();
        }return deposit;
    }

    public void createDeposit(Deposits deposit) {
        try {
            PreparedStatement statement = getConnection().prepareStatement("INSERT INTO " +
                    "deposits (clientId, bankId, minimumContribution, percentagePerAnnum, term) VALUES (?,?,?,?,?)");
            statement.setInt(1, deposit.getClient().getId());
            statement.setInt(2, deposit.getBank().getId());
            statement.setInt(3, deposit.getMinimumContribution());
            statement.setInt(4, deposit.getPercentagePerAnnum());
            statement.setInt(5, deposit.getTerm());
            int st = statement.executeUpdate();
            LOGGER.info(st + " records inserted");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public void updateDeposit(Deposits deposit) {
        try {
            PreparedStatement statement = getConnection().prepareStatement("UPDATE deposits SET clientId = ?, bankId = ?, minimumContribution = ?, percentagePerAnnum = ?, term = ? WHERE id = ?");
            statement.setInt(1, deposit.getClient().getId());
            statement.setInt(2, deposit.getBank().getId());
            statement.setInt(3, deposit.getMinimumContribution());
            statement.setInt(4, deposit.getPercentagePerAnnum());
            statement.setInt(5, deposit.getTerm());
            statement.setInt(6, deposit.getId());
            statement.executeUpdate();
            LOGGER.info("Successfully updated");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public void deleteDeposit(Deposits deposit) {
        try{
            PreparedStatement statement = getConnection().prepareStatement("DELETE FROM deposits WHERE id = ?");
            statement.setInt(1, deposit.getId());
            statement.execute();
            LOGGER.info("Successfully deleted");
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public List<Deposits> getDeposits(int minimumContribution, int term){
        List<Deposits> depositsList  = new ArrayList<>();
        try {
            PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM deposits WHERE   minimumContribution < ? AND term > ?");
            statement.setInt(1, minimumContribution);
            statement.setInt(2, term);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Deposits deposit = new Deposits();
                deposit.setId(resultSet.getInt("id"));
                deposit.setClient(new ClientsDAO().getClientByID(resultSet.getInt("clientId")));
                deposit.setBank(new BanksDAO().getBankByID(resultSet.getInt("bankId")));
                deposit.setMinimumContribution(resultSet.getInt("minimumContribution"));
                deposit.setPercentagePerAnnum(resultSet.getInt("percentagePerAnnum"));
                deposit.setTerm(resultSet.getInt("term"));
                depositsList.add(deposit);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally{
            closeAll();
        }return depositsList;
    }
}

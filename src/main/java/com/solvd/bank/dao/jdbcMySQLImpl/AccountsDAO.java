package com.solvd.bank.dao.jdbcMySQLImpl;

import com.solvd.bank.dao.IAccountsDAO;
import com.solvd.bank.models.Accounts;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ResourceBundle;
import java.sql.*;

public class AccountsDAO implements IAccountsDAO {

    private static final Logger LOGGER = LogManager.getLogger(AccountsDAO.class);
    static final String DATABASE_URL = "jdbc:mysql://localhost/bank";
    static final String USER = "root";
    static final String PASSWORD = "QWEasdzxc123";
    ResourceBundle resource = ResourceBundle.getBundle("db");
    String url = resource.getString("db.url");
    String user = resource.getString("db.username");
    String password = resource.getString("db.password");

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //getAllDoctors();
    }

//    @Override
//    public void updateDoctorById(int id) {
//        try (Connection con = DriverManager.getConnection(url, user, pass)) {
//
//            PreparedStatement stmt = con.prepareStatement("UPDATE Doctors SET availaibleDate=? WHERE id=?");
//            stmt.setString(1, "2022-05-19");
//            stmt.setInt(2, 9);
//
//            int i = stmt.executeUpdate();
//            LOGGER.info(i + " records updated");
//
//        } catch (Exception e) {
//            LOGGER.info(e);
//        }
//    }
//
//    @Override
//    public void deleteDoctorById(int id) {
//        try (Connection con = DriverManager.getConnection(url, user, pass)) {
//
//            PreparedStatement stmt = con.prepareStatement("DELETE FROM Doctors WHERE id=?");
//            stmt.setInt(1, 9);
//
//            int i = stmt.executeUpdate();
//            LOGGER.info(i + " records deleted");
//
//        } catch (Exception e) {
//            LOGGER.info(e);
//        }
//    }
//
//    @Override
//    public DoctorsModel getDoctorByDate(String date) {
//        try (Connection con = DriverManager.getConnection(url, user, pass)) {
//
//            PreparedStatement stmt = con.prepareStatement("SELECT * " +
//                    "FROM Doctors WHERE availaibleDate LIKE ? ESCAPE '!'");
//            stmt.setString(1, date + "%");
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                LOGGER.info("Id: " + rs.getInt(1) + "\n"
//                        + "Availaible Date: " + rs.getString(2) +
//                        "\n Person Id:  " + rs.getInt(3));
//            }
//        } catch (Exception e) {
//            LOGGER.info(e);
//        }
//        return null;
//    }
//
//    public static void getAllDoctors() throws ClassNotFoundException, SQLException {
//        Connection connection = null;
//        Statement statement = null;
//
//        LOGGER.info("Registering JDBC driver...");
//
//        Class.forName("com.mysql.cj.jdbc.Driver");
//
//        LOGGER.info("Creating database connection...");
//        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
//
//        LOGGER.info("Executing statement...");
//        statement = connection.createStatement();
//
//        String sql;
//        sql = "SELECT * FROM Doctors";
//
//        ResultSet resultSet = statement.executeQuery(sql);
//
//        LOGGER.info("Retrieving data from database...");
//        LOGGER.info("\nDoctors:");
//        while (resultSet.next()) {
//            int id = resultSet.getInt("id");
//            String availaibleDate = resultSet.getString("availaibleDate");
//            int personId = resultSet.getInt("Person_id");
//
//            LOGGER.info("\n================\n");
//            LOGGER.info("id: " + id);
//            LOGGER.info("Availaible Date:" + availaibleDate);
//            LOGGER.info("Person Id: " + personId);
//        }
//
//        LOGGER.info("Closing connection and releasing resources...");
//        resultSet.close();
//        statement.close();
//        connection.close();
//    }
//
    public Accounts getAccountByID(int id) {
        return null;
    }

    @Override
    public void createAccount(Accounts account) {
//        try (Connection connection = DriverManager.getConnection(url, user, password)) {
//            String sql = "INSERT INTO `users` (`name`, `role`) VALUES (?, ?)";
//
//            PreparedStatement statement = connection.prepareStatement("INSERT INTO `accounts` " +
//                    "(`id`, `number`, `client`, ) VALUES (?, ?, ?);");
//            stmt.setInt(1, id);
//            stmt.setString(2, availaibleDate);
//            stmt.setInt(3, personId);
//
//            int i = stmt.executeUpdate();
//            LOGGER.info(i + " records inserted");
//
//        } catch (Exception e) {
//            LOGGER.info(e);
//        }
//
//
//                // sends queries and receives results
//                PreparedStatement statement = connection.prepareStatement(sql,
//                        Statement.RETURN_GENERATED_KEYS);
//
//            // this way to prevent sql injection
//            statement.setString(1, "Matt");
//            statement.setString(2, "moderator");
//
//            int count= statement.executeUpdate();
//
//            if (count > 0) {
//                ResultSet result = statement.getGeneratedKeys();
//
//                if (result.next()) {
//                    int id = result.getInt(1);
//
//                    System.out.print("Last added user has id " + id + ".");
//                }
//            }
//        } catch (SQLException e) {
//            // some logic depending on scenario
//            // maybe LOGGER.log(e.getMessage()) and "result false"
//            e.printStackTrace();
//        }
    }

    public void updateAccount(Accounts account) {

    }

    public void deleteAccount(Accounts account) {

    }
}

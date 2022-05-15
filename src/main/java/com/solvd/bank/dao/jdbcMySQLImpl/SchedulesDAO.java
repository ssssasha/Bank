package com.solvd.bank.dao.jdbcMySQLImpl;

import com.solvd.bank.dao.ISchedulesDAO;
import com.solvd.bank.models.Accounts;
import com.solvd.bank.models.Schedules;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SchedulesDAO extends  AbstractDAO implements ISchedulesDAO {

    private static final Logger LOGGER = LogManager.getLogger(SchedulesDAO.class);

    public Schedules getScheduleByID(int id) {
        Schedules schedule = new Schedules();
        try {
            PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM schedules WHERE id = ?");
            statement.setInt(1,id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    schedule.setId(resultSet.getInt("id"));
                    schedule.setOpeningTime(resultSet.getString("openingTime"));
                    schedule.setClosingTime(resultSet.getString("closingTime"));
                    schedule.setDay(resultSet.getString("day"));
                }
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally {
            closeAll();
        }return schedule;
    }

    public void createSchedule(Schedules schedule) {
        try {
            PreparedStatement statement = getConnection().prepareStatement("INSERT INTO " +
                    "schedules (openingTime,closingTime,day) VALUES (?,?,?)");
            statement.setString(1, schedule.getOpeningTime());
            statement.setString(2, schedule.getClosingTime());
            statement.setString(3, schedule.getDay());
            int st = statement.executeUpdate();
            LOGGER.info(st + " records inserted");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public void updateSchedule(Schedules schedule) {
        try {
            PreparedStatement statement = getConnection().prepareStatement("UPDATE schedules SET openingTime = ?, closingTime = ?, day = ? WHERE id = ?");
            statement.setString(1, schedule.getOpeningTime());
            statement.setString(2, schedule.getClosingTime());
            statement.setString(3, schedule.getDay());
            statement.setInt(4, schedule.getId());
            statement.executeUpdate();
            LOGGER.info("Successfully updated");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public void deleteSchedule(Schedules schedule) {
        try{
            PreparedStatement statement = getConnection().prepareStatement("DELETE FROM schedules WHERE id = ?");
            statement.setInt(1, schedule.getId());
            statement.execute();
            LOGGER.info("Successfully deleted");
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public List<Schedules> getScheduleByDay(String day){
        List<Schedules> schedulesList  = new ArrayList<>();
        try {
            PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM schedules WHERE day = ?");
            statement.setString(1, day);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Schedules schedule = new Schedules();
                schedule.setId(resultSet.getInt("id"));
                schedule.setOpeningTime(resultSet.getString("openingTime"));
                schedule.setClosingTime(resultSet.getString("closingTime"));
                schedule.setDay(resultSet.getString("day"));
                schedulesList.add(schedule);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally{
            closeAll();
        }return schedulesList;
    }
}

package com.solvd.bank.dao.jdbcMySQLImpl;

import com.solvd.bank.dao.IDepartmentsDAO;
import com.solvd.bank.models.Accounts;
import com.solvd.bank.models.Banks;
import com.solvd.bank.models.Departments;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentsDAO extends AbstractDAO implements IDepartmentsDAO {

    private static final Logger LOGGER = LogManager.getLogger(DepartmentsDAO.class);

    public Departments getDepartmentByID(int id) {
        Departments department = new Departments();
        try {
            PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM departments WHERE id = ?");
            statement.setInt(1,id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    department.setId(resultSet.getInt("id"));
                    department.setBankId(resultSet.getInt("bankId"));
                    department.setAddressId(resultSet.getInt("addressId"));
                    department.setScheduleId(resultSet.getInt("scheduleId"));
                }
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally {
            closeAll();
        }return department;
    }

    public void createDepartment(Departments department) {
        try {
            PreparedStatement statement = getConnection().prepareStatement("INSERT INTO " +
                    "departments (bankId,addressId,scheduleId) VALUES (?,?,?)");
            statement.setInt(1, department.getBankId());
            statement.setInt(2, department.getAddressId());
            statement.setInt(3, department.getScheduleId());
            int st = statement.executeUpdate();
            LOGGER.info(st + " records inserted");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public void updateDepartment(Departments department) {
        try {
            PreparedStatement statement = getConnection().prepareStatement("UPDATE departments SET bankId = ?, addressId = ?, scheduleId = ? WHERE id = ?");
            statement.setInt(1, department.getBankId());
            statement.setInt(2, department.getAddressId());
            statement.setInt(3, department.getScheduleId());
            statement.executeUpdate();
            LOGGER.info("Successfully updated");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public void deleteDepartment(Departments department) {
        try{
            PreparedStatement statement = getConnection().prepareStatement("DELETE FROM departments WHERE id = ?");
            statement.setInt(1, department.getId());
            statement.execute();
            LOGGER.info("Successfully deleted");
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
    }

    public List<Departments> getDepartmentsByAddressId(int addressId){
        List<Departments> departmentsList  = new ArrayList<>();
        try {
            PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM departments WHERE addressId = ?");
            statement.setInt(1, addressId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Departments department = new Departments();
                department.setId(resultSet.getInt("id"));
                department.setBankId(resultSet.getInt("bankId"));
                department.setAddressId(resultSet.getInt("addressId"));
                department.setScheduleId(resultSet.getInt("scheduleId"));
                departmentsList.add(department);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally{
            closeAll();
        }return departmentsList;
    }
}

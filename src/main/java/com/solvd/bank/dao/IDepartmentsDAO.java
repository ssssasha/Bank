package com.solvd.bank.dao;

import com.solvd.bank.models.Departments;

import java.util.List;

public interface IDepartmentsDAO {

    Departments getDepartmentByID(int id);
    void createDepartment(Departments department);
    void updateDepartment(Departments department);
    void deleteDepartment(Departments department);
    List<Departments> getDepartmentsByAddressId(int addressId);
}

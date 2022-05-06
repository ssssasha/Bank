package com.solvd.bank.dao;

import com.solvd.bank.models.Departments;

public interface IDepartmentsDAO {

    Departments getDepartmentByID(int id);
    void createDepartment(Departments department);
    void updateDepartment(Departments department);
    void deleteDepartment(Departments department);
}

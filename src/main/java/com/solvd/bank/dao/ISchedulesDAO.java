package com.solvd.bank.dao;

import com.solvd.bank.models.Schedules;

import java.util.List;

public interface ISchedulesDAO {

    Schedules getScheduleByID(int id);
    void createSchedule(Schedules schedule);
    void updateSchedule(Schedules schedule);
    void deleteSchedule(Schedules schedule);
    List<Schedules> getScheduleByDay(String day);
}

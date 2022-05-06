package com.solvd.bank.dao;

import com.solvd.bank.models.Schedules;

public interface ISchedulesDAO {

    Schedules getScheduleByID(int id);
    void createSchedule(Schedules schedule);
    void updateSchedule(Schedules schedule);
    void deleteSchedule(Schedules schedule);
}

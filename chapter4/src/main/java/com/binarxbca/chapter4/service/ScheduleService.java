package com.binarxbca.chapter4.service;

import com.binarxbca.chapter4.model.Schedules;

import java.util.List;

public interface ScheduleService {
    public Schedules addSchedule(Schedules schedule);
    public Schedules getScheduleById(String id);
    public List<Schedules> getAllSchedules();
    public List<Schedules> getScheduleByFilmCode(String film_code);
    public Schedules updateSchedule(Schedules schedule);
    public void deleteSchedule(String id);
}

package com.binarxbca.chapter5.service;

import com.binarxbca.chapter5.model.schedule.Schedule;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleService {
    public Schedule addSchedule(Schedule schedule);
    public Schedule getScheduleById(String id);
    public List<Schedule> getScheduleByShowDate(LocalDate showDate);
    public List<Schedule> getScheduleByFilmId(String filmId);
    public List<Schedule> getScheduleByFilmName(String filmName);
    public List<Schedule> getAllSchedules();
    public Schedule updateSchedule(Schedule schedule);
    public void deleteSchedule(String id);
}
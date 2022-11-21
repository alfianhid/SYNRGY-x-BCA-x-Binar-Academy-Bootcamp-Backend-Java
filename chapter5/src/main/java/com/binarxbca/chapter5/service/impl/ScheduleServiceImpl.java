package com.binarxbca.chapter5.service.impl;

import com.binarxbca.chapter5.constant.ResponseMessage;
import com.binarxbca.chapter5.exception.DataNotFoundException;
import com.binarxbca.chapter5.model.schedule.Schedule;
import com.binarxbca.chapter5.repository.ScheduleRepository;
import com.binarxbca.chapter5.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;

    @Override
    public Schedule addSchedule(Schedule schedule) {
        // untuk mengaktifkan schedule
        schedule.setStatus(true);

        // menyimpan schedule
        return scheduleRepository.save(schedule);
    }

    @Override
    public Schedule getScheduleById(String id) {
        // validasi id
        verifyScheduleId(id);

        // cari schedule by id
        return scheduleRepository.findById(id).get();
    }

    @Override
    public List<Schedule> getScheduleByShowDate(LocalDate showDate) {
        return scheduleRepository.findScheduleByShowDate(showDate);
    }

    @Override
    public List<Schedule> getScheduleByFilmId(String filmId) {
        return scheduleRepository.findScheduleByFilmId(filmId);
    }

    @Override
    public List<Schedule> getScheduleByFilmName(String filmName) {
        return scheduleRepository.findScheduleByFilmName(filmName);
    }

    @Override
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    @Override
    public Schedule updateSchedule(Schedule schedule) {
        // validasi id
        verifyScheduleId(schedule.getId());

        // menyimpan schedule
        return scheduleRepository.save(schedule);
    }

    @Override
    public void deleteSchedule(String id) {
        // validasi id
        verifyScheduleId(id);

        // hapus schedule
        scheduleRepository.deleteById(id);
    }

    private void verifyScheduleId(String id){
        if(!scheduleRepository.findById(id).isPresent()){
            String message = String.format(ResponseMessage.NOT_FOUND_MESSAGE, "schedule", id);
            throw new DataNotFoundException(message);
        }
    }
}

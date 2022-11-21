package com.binarxbca.chapter4.service;

import com.binarxbca.chapter4.constant.ResponseMessage;
import com.binarxbca.chapter4.exception.DataNotFoundException;
import com.binarxbca.chapter4.model.Schedules;
import com.binarxbca.chapter4.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;

    @Override
    public Schedules addSchedule(Schedules schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    public Schedules getScheduleById(String id) {
        verifySchedule(id);
        return scheduleRepository.findById(id).get();
    }

    @Override
    public List<Schedules> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public List<Schedules> getScheduleByFilmCode(String film_code) {
        return scheduleRepository.findScheduleByFilmCode(film_code);
    }

    @Override
    public Schedules updateSchedule(Schedules schedule) {
        verifySchedule(schedule.getSchedule_id());
        return scheduleRepository.save(schedule);
    }

    @Override
    public void deleteSchedule(String id) {
        verifySchedule(id);
        scheduleRepository.deleteById(id);
    }

    private void verifySchedule(String id){
        if(!scheduleRepository.findById(id).isPresent()){
            String message = String.format(ResponseMessage.NOT_FOUND_MESSAGE, "schedule", id);
            throw new DataNotFoundException(message);
        }
    }
}

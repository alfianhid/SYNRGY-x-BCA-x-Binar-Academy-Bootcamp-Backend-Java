package com.binarxbca.chapter5.controller;

import com.binarxbca.chapter5.model.schedule.Schedule;
import com.binarxbca.chapter5.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;

    @PostMapping("/add")
    public Schedule addSchedule(@Valid @RequestBody Schedule schedule){
        return scheduleService.addSchedule(schedule);
    }

    @GetMapping("/id/{id}")
    public Schedule getScheduleById(@PathVariable String id){
        return scheduleService.getScheduleById(id);
    }

    @GetMapping("/show_date/{show_date}")
    public List<Schedule> getScheduleByShowDate(@PathVariable LocalDate showDate){
        return scheduleService.getScheduleByShowDate(showDate);
    }

    @GetMapping("/film_id/{film_id}")
    public List<Schedule> getScheduleByFilmId(@PathVariable String filmId){
        return scheduleService.getScheduleByFilmId(filmId);
    }

    @GetMapping("/film_name")
    public List<Schedule> getScheduleByFilmName(@RequestParam String filmName){
        return scheduleService.getScheduleByFilmName(filmName);
    }

    @GetMapping
    public List<Schedule> getAllSchedules(){
        return scheduleService.getAllSchedules();
    }

    @PutMapping("/update")
    public Schedule updateSchedule(@Valid @RequestBody Schedule schedule){
        return scheduleService.updateSchedule(schedule);
    }

    @DeleteMapping("/delete")
    public void deleteSchedule(@RequestParam String id){
        scheduleService.deleteSchedule(id);
    }
}

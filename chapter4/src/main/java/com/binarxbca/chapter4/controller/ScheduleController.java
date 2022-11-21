package com.binarxbca.chapter4.controller;

import com.binarxbca.chapter4.model.Schedules;
import com.binarxbca.chapter4.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;

    @PostMapping("/add")
    public Schedules addSchedule(@RequestBody Schedules schedule){
        return scheduleService.addSchedule(schedule);
    }

    @GetMapping("/id/{id}")
    public Schedules getScheduleById(@PathVariable String id){
        return scheduleService.getScheduleById(id);
    }

    @GetMapping
    public List<Schedules> getAllSchedules(){
        return scheduleService.getAllSchedules();
    }

    @GetMapping("/film_code/{film_code}")
    public List<Schedules> getScheduleByFilmCode(@PathVariable String film_code){
        return scheduleService.getScheduleByFilmCode(film_code);
    }

    @PutMapping("/update")
    public Schedules updateSchedule(@RequestBody Schedules schedule){
        return scheduleService.updateSchedule(schedule);
    }

    @DeleteMapping("/delete")
    public void deleteSchedule(@RequestParam String id){
        scheduleService.deleteSchedule(id);
    }
}

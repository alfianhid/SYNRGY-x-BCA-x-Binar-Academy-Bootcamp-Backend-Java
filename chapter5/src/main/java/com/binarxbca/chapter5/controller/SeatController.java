package com.binarxbca.chapter5.controller;

import com.binarxbca.chapter5.model.seat.Seat;
import com.binarxbca.chapter5.model.seat.SeatId;
import com.binarxbca.chapter5.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/seat")
public class SeatController {
    @Autowired
    SeatService seatService;

    @PostMapping("/add")
    public Seat addSeat(@Valid @RequestBody Seat seat){
        return seatService.addSeat(seat);
    }

    @GetMapping("/id/{id}")
    public Seat getSeatById(@PathVariable Integer id){
        return seatService.getSeatById(id);
    }

    @GetMapping
    public List<Seat> getAllSeats(){
        return seatService.getAllSeats();
    }

    @PutMapping("/update")
    public Seat updateSeat(@Valid @RequestBody Seat seat){
        return seatService.updateSeat(seat);
    }

    @DeleteMapping("/delete")
    public void deleteSeat(@RequestParam Integer id){
        seatService.deleteSeat(id);
    }
}

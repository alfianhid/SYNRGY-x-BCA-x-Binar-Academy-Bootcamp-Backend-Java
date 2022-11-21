package com.binarxbca.chapter4.controller;

import com.binarxbca.chapter4.model.SeatId;
import com.binarxbca.chapter4.model.Seats;
import com.binarxbca.chapter4.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seats")
public class SeatController {
    @Autowired
    SeatService seatService;

    @PostMapping("/add")
    public Seats addSeat(@RequestBody Seats seat){
        return seatService.addSeat(seat);
    }

    @GetMapping("/seat_number/{seat_number}")
    public Seats getSeatBySeatNumber(@PathVariable SeatId seat_number){
        return seatService.getSeatBySeatNumber(seat_number);
    }

    @GetMapping
    public List<Seats> getAllSeats(){
        return seatService.getAllSeats();
    }

    @PutMapping("/update")
    public Seats updateSeat(@RequestBody Seats seat){
        return seatService.updateSeat(seat);
    }

    @DeleteMapping("/delete")
    public void deleteSeat(@RequestParam SeatId seat_number){
        seatService.deleteSeat(seat_number);
    }
}

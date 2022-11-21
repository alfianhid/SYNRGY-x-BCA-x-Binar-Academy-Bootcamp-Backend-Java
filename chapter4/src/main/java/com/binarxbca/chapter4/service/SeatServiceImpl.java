package com.binarxbca.chapter4.service;

import com.binarxbca.chapter4.constant.ResponseMessage;
import com.binarxbca.chapter4.exception.DataNotFoundException;
import com.binarxbca.chapter4.model.SeatId;
import com.binarxbca.chapter4.model.Seats;
import com.binarxbca.chapter4.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {
    @Autowired
    SeatRepository seatRepository;

    @Override
    public Seats addSeat(Seats seat) {
        return seatRepository.save(seat);
    }

    @Override
    public Seats getSeatBySeatNumber(SeatId seat_number) {
        verifySeat(seat_number);
        return seatRepository.findById(seat_number).get();
    }

    @Override
    public List<Seats> getAllSeats() {
        return seatRepository.findAll();
    }

    @Override
    public Seats updateSeat(Seats seat) {
        verifySeat(seat.getSeat_number());
        return seatRepository.save(seat);
    }

    @Override
    public void deleteSeat(SeatId seat_number) {
        verifySeat(seat_number);
        seatRepository.deleteById(seat_number);
    }

    private void verifySeat(SeatId seat_number){
        if(!seatRepository.findById(seat_number).isPresent()){
            String message = String.format(ResponseMessage.NOT_FOUND_MESSAGE, "seat", seat_number);
            throw new DataNotFoundException(message);
        }
    }
}

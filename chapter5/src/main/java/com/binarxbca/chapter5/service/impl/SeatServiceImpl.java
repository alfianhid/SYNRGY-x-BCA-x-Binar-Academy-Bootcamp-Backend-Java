package com.binarxbca.chapter5.service.impl;

import com.binarxbca.chapter5.constant.ResponseMessage;
import com.binarxbca.chapter5.exception.DataAlreadyExistsException;
import com.binarxbca.chapter5.exception.DataNotFoundException;
import com.binarxbca.chapter5.model.seat.Seat;
import com.binarxbca.chapter5.repository.SeatRepository;
import com.binarxbca.chapter5.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {
    @Autowired
    SeatRepository seatRepository;

    @Override
    public Seat addSeat(Seat seat) {
        verifySeatNumber(seat);
        return seatRepository.save(seat);
    }

    @Override
    public Seat getSeatById(Integer id) {
        verifySeatId(id);
        return seatRepository.findById(id).get();
    }

    @Override
    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    @Override
    public Seat updateSeat(Seat seat) {
        verifySeatId(seat.getSeatId().getId());
        return seatRepository.save(seat);
    }

    @Override
    public void deleteSeat(Integer id) {
        verifySeatId(id);
        seatRepository.deleteById(id);
    }

    private void verifySeatId(Integer id){
        if(!seatRepository.findById(id).isPresent()){
            String message = String.format(ResponseMessage.NOT_FOUND_MESSAGE, "seat", id);
            throw new DataNotFoundException(message);
        }
    }

    private void verifySeatNumber(Seat seat) {
        if(seatRepository.findById(seat.getSeatId().getId()).isPresent()) {
            String message = String.format(ResponseMessage.SEAT_ID_ALREADY_EXISTS, "seat", seat.getSeatId().getId());
            throw new DataAlreadyExistsException(message);
        }
    }
}

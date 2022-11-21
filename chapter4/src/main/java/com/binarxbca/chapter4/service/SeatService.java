package com.binarxbca.chapter4.service;

import com.binarxbca.chapter4.model.SeatId;
import com.binarxbca.chapter4.model.Seats;

import java.util.List;

public interface SeatService {
    public Seats addSeat(Seats seat);
    public Seats getSeatBySeatNumber(SeatId seat_number);
    public List<Seats> getAllSeats();
    public Seats updateSeat(Seats seat);
    public void deleteSeat(SeatId seat_number);
}

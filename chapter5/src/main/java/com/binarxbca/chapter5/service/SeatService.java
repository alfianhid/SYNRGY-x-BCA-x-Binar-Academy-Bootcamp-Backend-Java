package com.binarxbca.chapter5.service;

import com.binarxbca.chapter5.model.seat.Seat;

import java.util.List;

public interface SeatService {
    public Seat addSeat(Seat seat);
    public Seat getSeatById(Integer id);
    public List<Seat> getAllSeats();
    public Seat updateSeat(Seat seat);
    public void deleteSeat(Integer id);
}

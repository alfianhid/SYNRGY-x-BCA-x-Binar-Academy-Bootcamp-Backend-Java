package com.binarxbca.chapter5.service;

import com.binarxbca.chapter5.model.Seat;
import com.binarxbca.chapter5.payload.response.ApiResponse;
import com.binarxbca.chapter5.payload.response.PagedResponse;
import org.springframework.http.ResponseEntity;

public interface SeatService {

	PagedResponse<Seat> getAllSeats(int page, int size);

	ResponseEntity<Seat> getSeat(Long id);

	ResponseEntity<Seat> addSeat(Seat seat);

	ResponseEntity<Seat> updateSeat(Long id, Seat newSeat);

	ResponseEntity<ApiResponse> deleteSeat(Long id);

}

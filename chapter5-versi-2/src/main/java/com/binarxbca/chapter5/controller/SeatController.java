package com.binarxbca.chapter5.controller;

import com.binarxbca.chapter5.model.Seat;
import com.binarxbca.chapter5.payload.response.ApiResponse;
import com.binarxbca.chapter5.payload.response.PagedResponse;
import com.binarxbca.chapter5.service.SeatService;
import com.binarxbca.chapter5.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/chapter5/seats")
public class SeatController {
	@Autowired
	private SeatService seatService;

	@GetMapping
	public PagedResponse<Seat> getAllSeats(
			@RequestParam(name = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
			@RequestParam(name = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {
		return seatService.getAllSeats(page, size);
	}

	@PostMapping
	public ResponseEntity<Seat> addSeat(@Valid @RequestBody Seat seat) {

		return seatService.addSeat(seat);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Seat> getSeat(@PathVariable(name = "id") Long id) {
		return seatService.getSeat(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Seat> updateSeat(@PathVariable(name = "id") Long id,
			@Valid @RequestBody Seat seat) {
		return seatService.updateSeat(id, seat);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteSeat(@PathVariable(name = "id") Long id) {
		return seatService.deleteSeat(id);
	}

}

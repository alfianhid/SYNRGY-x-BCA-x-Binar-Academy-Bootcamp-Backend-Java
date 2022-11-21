package com.binarxbca.chapter5.controller;

import com.binarxbca.chapter5.payload.request.ScheduleRequest;
import com.binarxbca.chapter5.payload.response.ApiResponse;
import com.binarxbca.chapter5.payload.response.PagedResponse;
import com.binarxbca.chapter5.payload.response.ScheduleResponse;
import com.binarxbca.chapter5.service.ScheduleService;
import com.binarxbca.chapter5.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/chapter5/schedules")
public class ScheduleController {
	@Autowired
	private ScheduleService scheduleService;

	@GetMapping
	public PagedResponse<ScheduleResponse> getAllSchedules(
			@RequestParam(name = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
			@RequestParam(name = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {
		return scheduleService.getAllSchedules(page, size);
	}

	@PostMapping
	public ResponseEntity<ScheduleResponse> addSchedule(@Valid @RequestBody ScheduleRequest scheduleRequest) {
		ScheduleResponse scheduleResponse = scheduleService.addSchedule(scheduleRequest);

		return new ResponseEntity<>(scheduleResponse, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ScheduleResponse> getSchedule(@PathVariable(name = "id") Long id) {
		ScheduleResponse scheduleResponse = scheduleService.getSchedule(id);

		return new ResponseEntity<>(scheduleResponse, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ScheduleResponse> updateSchedule(@PathVariable(name = "id") Long id,
                                                        @Valid @RequestBody ScheduleRequest scheduleRequest) {

		ScheduleResponse scheduleResponse = scheduleService.updateSchedule(id, scheduleRequest);

		return new ResponseEntity<>(scheduleResponse, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteSchedule(@PathVariable(name = "id") Long id) {
		ApiResponse apiResponse = scheduleService.deleteSchedule(id);

		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}
}

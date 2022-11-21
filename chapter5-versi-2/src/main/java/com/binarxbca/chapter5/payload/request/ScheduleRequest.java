package com.binarxbca.chapter5.payload.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ScheduleRequest {
	@NotNull
	private Long id;

	@NotBlank
	@Size(min = 10, message = "show_date must be minimum 10 characters")
	private String showDate;

	@NotBlank
	@Size(min = 5, message = "start_time must be minimum 5 characters")
	private String startTime;

	@NotBlank
	@Size(min = 5, message = "end_time must be minimum 5 characters")
	private String endTime;

	@NotNull
	private Long filmId;
}

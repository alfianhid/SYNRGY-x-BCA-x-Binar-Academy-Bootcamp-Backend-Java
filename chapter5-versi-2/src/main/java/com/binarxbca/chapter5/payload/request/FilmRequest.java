package com.binarxbca.chapter5.payload.request;

import com.binarxbca.chapter5.model.Schedule;
import com.binarxbca.chapter5.model.User;
import com.binarxbca.chapter5.payload.DateAuditPayload;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class FilmRequest extends DateAuditPayload {
	@NotNull
	private Long id;

	@NotBlank
	@Size(max = 100, message = "title must be maximum 100 characters")
	private String title;

	@NotBlank
	@Size(max = 3, message = "rating must be maximum 10 characters")
	private String rating;

	@NotBlank
	private Integer stock;

	@NotBlank
	private Double ticketPrice;

	@NotBlank
	private Boolean isShowing;

	private User user;

	private List<Schedule> schedules;

	public List<Schedule> getSchedule() {

		return schedules == null ? null : new ArrayList<>(schedules);
	}

	public void setSchedule(List<Schedule> schedules) {

		if (schedules == null) {
			this.schedules = null;
		} else {
			this.schedules = Collections.unmodifiableList(schedules);
		}
	}
}

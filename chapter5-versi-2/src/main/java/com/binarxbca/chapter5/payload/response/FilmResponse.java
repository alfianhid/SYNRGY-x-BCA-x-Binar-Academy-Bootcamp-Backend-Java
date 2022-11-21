package com.binarxbca.chapter5.payload.response;

import com.binarxbca.chapter5.model.Schedule;
import com.binarxbca.chapter5.payload.DateAuditPayload;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.binarxbca.chapter5.model.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@JsonInclude(Include.NON_NULL)
public class FilmResponse extends DateAuditPayload {
	private Long id;

	private String title;

	private String rating;

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
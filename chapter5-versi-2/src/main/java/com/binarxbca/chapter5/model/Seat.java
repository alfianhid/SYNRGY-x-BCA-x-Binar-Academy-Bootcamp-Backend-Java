package com.binarxbca.chapter5.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table(name = "seats", uniqueConstraints = { @UniqueConstraint(columnNames = { "studio_name" }) })
public class Seat extends DateAudit {
	@EmbeddedId
	private SeatId seatId;

	@NotBlank
	@Column(name = "studio_name")
	private String studioName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	public User getUser() {
		return user;
	}
}

package com.binarxbca.chapter4.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Table(name = "schedules")
@Entity
@Getter
@Setter
public class Schedules {
    @Id
    @Column(name = "schedule_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String schedule_id;

    @Column(name = "show_date", nullable = false)
    private LocalDate show_date;

    @Column(name = "start_time", nullable = false)
    private LocalTime start_time;

    @Column(name = "end_time", nullable = false)
    private LocalTime end_time;

    @Column(name = "ticket_price", nullable = false)
    private Double ticket_price;

    @ManyToOne
    @JoinColumn(name = "film_code")
    private Films films;
}

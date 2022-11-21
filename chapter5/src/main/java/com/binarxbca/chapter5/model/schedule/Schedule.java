package com.binarxbca.chapter5.model.schedule;

import com.binarxbca.chapter5.model.AuditModel;
import com.binarxbca.chapter5.model.film.Film;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalTime;

@Table(name = "schedule")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Schedule extends AuditModel {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @Column(name = "show_date", nullable = false)
    @NotEmpty(message = "show date must not be empty!")
    private LocalDate showDate;

    @Column(name = "start_time", nullable = false)
    @NotEmpty(message = "start time must not be empty!")
    private LocalTime startTime;

    @Column(name = "end_time", nullable = false)
    @NotEmpty(message = "end time must not be empty!")
    private LocalTime endTime;

    @Column(name = "ticket_price", nullable = false)
    @NotEmpty(message = "ticket price must not be empty!")
    private Double ticketPrice;

    @Column(name = "status")
    private Boolean status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "film_id", nullable = false)
    private Film film;

    @Override
    public String toString() {
        return "Schedule{" +
                "id='" + id + '\'' +
                ", show_date=" + showDate +
                ", start_time=" + startTime +
                ", end_time=" + endTime +
                ", ticket_price=" + ticketPrice +
                ", film=" + film +
                '}';
    }
}

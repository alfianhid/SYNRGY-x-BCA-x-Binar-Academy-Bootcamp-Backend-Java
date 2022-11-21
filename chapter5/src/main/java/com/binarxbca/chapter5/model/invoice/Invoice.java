package com.binarxbca.chapter5.model.invoice;

import com.binarxbca.chapter5.model.AuditModel;
import com.binarxbca.chapter5.model.schedule.Schedule;
import com.binarxbca.chapter5.model.seat.Seat;
import com.binarxbca.chapter5.model.user.User;
import com.binarxbca.chapter5.model.film.Film;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table(name = "invoice")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Invoice extends AuditModel {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @Column(name = "file_name")
    private String fileName;

    @Lob
    @Column(name = "file")
    private byte[] file;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "film_id")
    private Film film;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns( {
            @JoinColumn(name="seat_id", referencedColumnName="id"),
            @JoinColumn(name="seat_row", referencedColumnName="row"),
            @JoinColumn(name="seat_status", referencedColumnName="status")
    } )
    private Seat seat;
}

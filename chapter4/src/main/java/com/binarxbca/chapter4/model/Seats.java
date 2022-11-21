package com.binarxbca.chapter4.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "seats")
@Entity
@Getter
@Setter
public class Seats {
    @EmbeddedId
    private SeatId seat_number;

    @Column(name = "studio_name", nullable = false, length = 3)
    private String studio_name;
}

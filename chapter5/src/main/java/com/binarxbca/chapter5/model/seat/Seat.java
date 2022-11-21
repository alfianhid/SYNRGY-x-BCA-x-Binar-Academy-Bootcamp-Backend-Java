package com.binarxbca.chapter5.model.seat;

import com.binarxbca.chapter5.model.AuditModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Table(name = "seat")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Seat extends AuditModel {
    @EmbeddedId
    private SeatId seatId;

    @Column(name = "studio_name", nullable = false, length = 1)
    @NotEmpty(message = "studio name must not be empty!")
    private String studioName;

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + seatId +
                ", studio_name='" + studioName + '\'' +
                '}';
    }
}

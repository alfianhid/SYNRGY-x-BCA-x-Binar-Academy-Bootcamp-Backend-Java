package com.binarxbca.chapter5.model;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
public class SeatId implements Serializable {
    private Long id;
    private String row;
    private Boolean status;
}
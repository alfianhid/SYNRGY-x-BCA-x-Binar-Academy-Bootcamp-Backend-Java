package com.binarxbca.chapter4.model;


import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class SeatId implements Serializable {
    private Integer seat_number;
    private Boolean seat_status;


}
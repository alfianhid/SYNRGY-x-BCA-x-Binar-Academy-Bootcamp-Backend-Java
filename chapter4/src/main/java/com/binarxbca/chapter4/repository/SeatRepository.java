package com.binarxbca.chapter4.repository;

import com.binarxbca.chapter4.model.SeatId;
import com.binarxbca.chapter4.model.Seats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seats, SeatId> {
}

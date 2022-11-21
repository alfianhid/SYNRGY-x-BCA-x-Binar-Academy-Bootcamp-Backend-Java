package com.binarxbca.chapter5.repository;

import com.binarxbca.chapter5.model.seat.SeatId;
import com.binarxbca.chapter5.model.seat.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {
    @Query(value = "select * from seat where studio_name = :studio_name", nativeQuery = true)
    public List<Seat> findSeatByStudioName(@Param("studio_name") String studioName);
}

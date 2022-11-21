package com.binarxbca.chapter4.repository;

import com.binarxbca.chapter4.model.Schedules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedules, String> {
    @Query(value = "select * from schedules where film_code= :film_code", nativeQuery = true)
    List<Schedules> findScheduleByFilmCode(String film_code);
}

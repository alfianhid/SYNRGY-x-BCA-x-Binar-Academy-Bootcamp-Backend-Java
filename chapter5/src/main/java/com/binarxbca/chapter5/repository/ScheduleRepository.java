package com.binarxbca.chapter5.repository;

import com.binarxbca.chapter5.model.schedule.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, String> {
    @Query(value = "select * from schedule where show_date = :show_date", nativeQuery = true)
    public List<Schedule> findScheduleByShowDate(@Param("show_date") LocalDate showDate);

    @Query(value = "select * from schedule where film_id = :film_id", nativeQuery = true)
    public List<Schedule> findScheduleByFilmId(@Param("film_id") String filmId);

    @Query(value = "SELECT * FROM schedule WHERE film_id IN (SELECT * FROM film WHERE name = :film_name", nativeQuery = true)
    public List<Schedule> findScheduleByFilmName(@Param("film_name") String filmName);
}

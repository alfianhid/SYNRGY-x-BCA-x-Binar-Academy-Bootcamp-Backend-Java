package com.binarxbca.chapter5.repository;

import com.binarxbca.chapter5.model.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
	Page<Schedule> findByFilmId(Long filmId, Pageable pageable);
}

package com.binarxbca.chapter5.repository;

import com.binarxbca.chapter5.model.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
	Page<Film> findByUserId(Long userId, Pageable pageable);
}

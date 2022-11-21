package com.binarxbca.chapter4.repository;

import com.binarxbca.chapter4.model.Films;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Films, String> {
}